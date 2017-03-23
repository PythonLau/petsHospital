package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbItem;

import java.math.BigDecimal;

public interface ItemService {
	TaotaoResult createItem(TbItem item) throws Exception;
	EUDataGridResult getItemList(int page, int rows);
	TbItem getItemById(BigDecimal itemId);
	TaotaoResult updateItem(TbItem item) throws Exception;
	TaotaoResult deleteItem(String ids) throws Exception;
	EUDataGridResult searchItemList(String search_condition,String search_key,Integer page,Integer rows);
}
