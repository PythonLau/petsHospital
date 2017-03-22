package com.coco.service;

import com.coco.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
public interface PositionCatService {
    List<EUTreeNode> getCatList(long parentId);
}
