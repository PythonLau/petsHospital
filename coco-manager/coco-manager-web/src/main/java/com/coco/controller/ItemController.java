package com.coco.controller;

import com.coco.common.pojo.Ids;
import com.coco.common.pojo.search_params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbItem;
import com.coco.service.ItemService;

import java.util.List;
import java.util.Map;

/**
 * 商品管理Controller
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月2日上午10:52:46
 * @version 1.0
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult createItem(TbItem item) throws Exception {
		TaotaoResult result = itemService.createItem(item);
		return result;
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		System.out.println(page);
		System.out.println(rows);
		System.out.println("itemlist...controller");
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	@RequestMapping("/item/delete")
	@ResponseBody
	public TaotaoResult deleteItem(@RequestBody Ids ids) throws Exception{
		String deleteIds = ids.getIds();
        TaotaoResult result = itemService.deleteItem(deleteIds);
		return result;
	}

	@RequestMapping("/item/search")
	@ResponseBody
	public EUDataGridResult searchItem(@RequestBody search_params search_params) throws Exception{
		System.out.println(search_params.getSearch_condition());
		System.out.println(search_params.getSearch_key());
		return null;
	}
}
