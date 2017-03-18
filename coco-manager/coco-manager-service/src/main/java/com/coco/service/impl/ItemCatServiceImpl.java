package com.coco.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.coco.common.pojo.TaotaoResult;
import com.coco.mapper.TbItemCatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coco.common.pojo.EUTreeNode;
import com.coco.pojo.TbItemCat;
import com.coco.pojo.TbItemCatExample;
import com.coco.pojo.TbItemCatExample.Criteria;
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
	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		
		//创建查询条件
		System.out.println("service....");
		System.out.println(parentId);
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//根据条件查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		System.out.println("size...");
		System.out.println(list.size());
		List<EUTreeNode> resultList = new ArrayList<>();
		//把列表转换成treeNodelist
		for (TbItemCat tbItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		//返回结果
		return resultList;
	}
	@Override
	public TaotaoResult insertItemCat(long parentId, String name){
		//创建一个pojo
		TbItemCat tbItemCat = new TbItemCat();
		tbItemCat.setName(name);
		tbItemCat.setIsParent(false);
		//'状态。可选值:1(正常),2(删除)',
		tbItemCat.setStatus(1);
		tbItemCat.setParentId(parentId);
		tbItemCat.setSortOrder(1);
		//添加记录
		itemCatMapper.insert(tbItemCat);
		//查看父节点的isParent列是否为true，如果不是true改成true
		TbItemCat parentCat = itemCatMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			itemCatMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoResult.ok(tbItemCat);
	}

	@Override
	public TaotaoResult deleteItemCat(long id){
		//查询要删除节点自身的实例
		TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(id);
		//找出他的父节点ID
		Long parentId = itemCat.getParentId();
		//删除Example，并且删除
		TbItemCatExample deleteExample = new TbItemCatExample();
		Criteria criteria2 = deleteExample.createCriteria();
		criteria2.andIdEqualTo(id);
		itemCatMapper.deleteByExample(deleteExample);
		//查询父节点下面的子节点个数
		TbItemCatExample selectExample = new TbItemCatExample();
		Criteria criteria = selectExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(selectExample);
		if(list.size() == 0){
			TbItemCat parentCat = itemCatMapper.selectByPrimaryKey(parentId);
			parentCat.setIsParent(false);
			itemCatMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult updateItemCat(long id,String name){
		TbItemCat tbItemCat = itemCatMapper.selectByPrimaryKey(id);
		tbItemCat.setName(name);
		itemCatMapper.updateByPrimaryKey(tbItemCat);
		return TaotaoResult.ok();
	}
}
