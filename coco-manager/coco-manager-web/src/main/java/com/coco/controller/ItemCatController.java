package com.coco.controller;

import java.math.BigDecimal;
import java.util.List;

import com.coco.common.pojo.TaotaoResult;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coco.common.pojo.EUTreeNode;
import com.coco.service.ItemCatService;

/**
 * 商品分类管理controller
 * <p>Title: ItemCatController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月4日上午9:25:14
 * @version 1.0
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	private List<EUTreeNode> getCatList(@RequestParam(value="id",defaultValue="0")BigDecimal parentId) {
		System.out.println("controller..../list");
		System.out.println(parentId);
		List<EUTreeNode> list = itemCatService.getCatList(parentId);
		System.out.println("controller ----list");
		System.out.println(list.get(0).getClass().toString());

		return list;
	}

	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult addTbItemCat(BigDecimal parentId, String name) {
		System.out.println("controller..../create");
		TaotaoResult result = itemCatService.insertItemCat(parentId, name);
		return result;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteTbItemCat(BigDecimal id) {
		System.out.println("controller..../delete");
		TaotaoResult result = itemCatService.deleteItemCat(id);
		return result;
	}

	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateTbItemCat(BigDecimal id,String name) {
		System.out.println("controller..../update");
		TaotaoResult result = itemCatService.updateItemCat(id,name);
		return result;
	}
}
