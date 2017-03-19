package com.coco.service;

import java.util.List;

import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;

public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
	TaotaoResult insertItemCat(long parentId, String name);
	TaotaoResult deleteItemCat(long id);
	TaotaoResult updateItemCat(long id,String name);
	boolean judgeDeleteItemCat(long id);
}
