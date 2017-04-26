package com.coco.service;

import com.coco.common.pojo.EUTreeNode;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public interface OperatingRoomService {
    List<EUTreeNode> getOperatingRoomList(BigDecimal parentId);
}
