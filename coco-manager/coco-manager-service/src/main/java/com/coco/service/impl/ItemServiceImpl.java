package com.coco.service.impl;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.mapper.TbItemMapper;
import com.coco.pojo.TbItem;
import com.coco.pojo.TbItemExample;
import com.coco.pojo.TbItemExample.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
    private Short isTrue = 1;
    private Short isFalse = 0;
	@Override
	public TaotaoResult createItem(TbItem item) throws Exception {
		//item补全
		//生成商品ID
		Long itemId = IDUtils.genItemId();
		BigDecimal item_id = new BigDecimal(itemId);
		item.setId(item_id);
		// '商品状态，1-正常，2-下架，3-删除',
		item.setStatus(isTrue);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//插入到数据库
		itemMapper.insert(item);
		//添加商品描述信息
		return TaotaoResult.ok();
	}

	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TbItem getItemById(BigDecimal itemId) {

		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

	@Override
	public TaotaoResult updateItem(TbItem item) throws Exception {

		item.setStatus(isTrue);
		item.setCreated(null);
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKey(item);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteItem(String ids) throws Exception{
		List<String> result = Arrays.asList(ids.split(","));
		for(String id : result){
			BigDecimal deleteId = new BigDecimal(id);
			itemMapper.deleteByPrimaryKey(deleteId);
		}
		return TaotaoResult.build(200,"删除物品成功");
	}

	@Override
	public EUDataGridResult searchItemList(String search_condition,String search_key,Integer page,Integer rows){
		System.out.println("service"  + search_condition);
		System.out.println("service" + search_key);
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		if(search_condition.equals("id")){
			BigDecimal id = new BigDecimal(search_key);
			criteria.andIdEqualTo(id);
		}else if(search_condition.equals("title")){
			criteria.andTitleEqualTo(search_key);
		}else if(search_condition.equals("cid")){
			Long cid = Long.parseLong(search_key);
			criteria.andCidEqualTo(cid);
		}else if(search_condition.equals("supplier")){
			criteria.andSupplierEqualTo(search_key);
		}else if(search_condition.equals("barcode")){
			criteria.andBarcodeEqualTo(search_condition);
		}else if(search_condition.equals("status")){
			Short status = new Short(search_key);
			criteria.andStatusEqualTo(status);
		}
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
