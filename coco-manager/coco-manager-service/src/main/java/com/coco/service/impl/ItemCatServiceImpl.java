package com.coco.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.coco.common.pojo.TaotaoResult;
import com.coco.mapper.TbItemCatMapper;
import com.coco.mapper.TbItemMapper;
import com.coco.pojo.TbItem;
import com.coco.pojo.TbItemCat;
import com.coco.pojo.TbItemCatExample;
import com.coco.pojo.TbItemExample;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coco.common.pojo.EUTreeNode;
import com.coco.service.ItemCatService;

/**
 * 商品分类管理
 * <p>Title: ItemCatServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月4日上午9:16:50
 * @version 1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Autowired
	private TbItemMapper itemMapper;
	private Short isTrue = 1;
	private Short isFalse = 0;
	@Override
	public List<EUTreeNode> getCatList(BigDecimal parentId) {
		TbItemCatExample example = new TbItemCatExample();
		TbItemCatExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		System.out.println("分类大小:" + list.size());
		List<EUTreeNode> resultList = new ArrayList<>();
		//把列表转换成treeNodelist
		for (TbItemCat tbItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			Short status = tbItemCat.getIsParent();
			Short judgeOne = 1;
			if(status.equals(judgeOne)){
				node.setState("closed");
			}else{
				node.setState("open");
			}
			resultList.add(node);
		}
		//返回结果
		return resultList;
	}
	@Override
	public TaotaoResult insertItemCat(BigDecimal parentId, String name){
		//创建一个pojo
		TbItemCat tbItemCat = new TbItemCat();
		tbItemCat.setName(name);
		tbItemCat.setIsParent(isFalse);
		//'状态。可选值:1(正常),2(删除)',
		tbItemCat.setStatus(isTrue);
		tbItemCat.setParentId(parentId);
		tbItemCat.setSortOrder(isTrue);
		//添加记录
		itemCatMapper.insert(tbItemCat);
		//查看父节点的isParent列是否为true，如果不是true改成true
		TbItemCat parentCat = itemCatMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(parentCat.getIsParent() == isFalse) {
			parentCat.setIsParent(isTrue);
			//更新父节点
			itemCatMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok(tbItemCat);
	}

	@Override
	public boolean judgeDeleteItemCat(BigDecimal id){
		//假如他下面没有分类并且没有商品，就返回true,否则返回false,如果还有分类就递归查询。
		TbItemCatExample judgeCatExample = new TbItemCatExample();
		TbItemCatExample.Criteria judgeCatCriteria = judgeCatExample.createCriteria();
		judgeCatCriteria.andParentIdEqualTo(id);
		List<TbItemCat> judgeCatList = itemCatMapper.selectByExample(judgeCatExample);

		if(judgeCatList.size() == 0){
			TbItemExample judgeItemExample = new TbItemExample();
			TbItemExample.Criteria judgeItemCriteria = judgeItemExample.createCriteria();
			judgeItemCriteria.andCidEqualTo(id.longValue());
			List<TbItem> judgeItemList = itemMapper.selectByExample(judgeItemExample);
			if(judgeItemList.size() == 0){
				return true;
			}else{
				return false;
			}
		}else {
			return false;
		}
	}

	@Override
	public TaotaoResult deleteItemCat(BigDecimal id){
		//判断该分类是否能删除
		//判断下面是否还存在有分类
        boolean canDelete = judgeDeleteItemCat(id);
		if(canDelete){
			//查询要删除节点自身的实例
			TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(id);
			//找出他的父节点ID
			BigDecimal parentId = itemCat.getParentId();
			//删除Example，并且删除
			TbItemCatExample deleteExample = new TbItemCatExample();
			TbItemCatExample.Criteria criteria2 = deleteExample.createCriteria();
			criteria2.andIdEqualTo(id);
			itemCatMapper.deleteByExample(deleteExample);
			//查询父节点下面的子节点个数
			TbItemCatExample selectExample = new TbItemCatExample();
			TbItemCatExample.Criteria criteria = selectExample.createCriteria();
			criteria.andParentIdEqualTo(parentId);
			List<TbItemCat> list = itemCatMapper.selectByExample(selectExample);
			if(list.size() == 0){
				TbItemCat parentCat = itemCatMapper.selectByPrimaryKey(parentId);
				parentCat.setIsParent(isFalse);
				itemCatMapper.updateByPrimaryKey(parentCat);
			}
			return TaotaoResult.build(200,"删除分类成功");
		}else{
			return TaotaoResult.build(500,"需要清空该分类下所有的分类以及物品才能删除该分类");
		}
	}

	@Override
	public TaotaoResult updateItemCat(BigDecimal id,String name){
		TbItemCat tbItemCat = itemCatMapper.selectByPrimaryKey(id);
		tbItemCat.setName(name);
		itemCatMapper.updateByPrimaryKey(tbItemCat);
		return TaotaoResult.ok();
	}
}
