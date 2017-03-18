package com.coco.service;

import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbItem;

public interface ItemService {
	TaotaoResult createItem(TbItem item) throws Exception;
}
