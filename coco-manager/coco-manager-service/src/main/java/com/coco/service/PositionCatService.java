package com.coco.service;

import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
public interface PositionCatService {
    List<EUTreeNode> getCatList(long parentId);
    TaotaoResult insertPositionCat(long parentId, String name);
    TaotaoResult updatePositionCat(long id,String name);
    TaotaoResult deletePositionCat(long id);
    boolean judgeDeletePositionCat(long id);
}
