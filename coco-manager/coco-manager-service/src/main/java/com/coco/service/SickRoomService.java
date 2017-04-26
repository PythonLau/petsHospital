package com.coco.service;

import com.coco.common.pojo.EUTreeNode;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/4/23 0023.
 */
public interface SickRoomService {
    List<EUTreeNode> getBedRoomListByDoctor(BigDecimal parentId);
}
