package com.coco.service;

import java.math.BigDecimal;
import java.util.List;

import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;

public interface ItemCatService {
	List<EUTreeNode> getCatList(BigDecimal parentId);
	TaotaoResult insertItemCat(BigDecimal parentId, String name);
	TaotaoResult deleteItemCat(BigDecimal id);
	TaotaoResult updateItemCat(BigDecimal id,String name);
	boolean judgeDeleteItemCat(BigDecimal id);
}
