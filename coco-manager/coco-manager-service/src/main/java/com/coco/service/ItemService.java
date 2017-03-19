package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbItem;

public interface ItemService {
	TaotaoResult createItem(TbItem item) throws Exception;
	EUDataGridResult getItemList(int page, int rows);
	TbItem getItemById(long itemId);
	TaotaoResult updateItem(TbItem item) throws Exception;
	TaotaoResult deleteItem(String ids) throws Exception;
}
