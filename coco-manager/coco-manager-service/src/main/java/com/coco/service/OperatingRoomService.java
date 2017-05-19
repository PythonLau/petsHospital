package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public interface OperatingRoomService {
    List<EUTreeNode> getOperatingRoomList(BigDecimal parentId);
    List<EUTreeNode> getRoomTreeListByManager(BigDecimal parentId);
    EUDataGridResult getRoomListByManager(Integer page,Integer rows);
    TaotaoResult createRoomByManager(BigDecimal parentId,String name);
    TaotaoResult updateRoomByManager(BigDecimal id,String name);
    TaotaoResult deleteRoomByManager(BigDecimal id);
    boolean judgeRoomCanDelete(BigDecimal id);
    Short getOperatingRoomStatus(BigDecimal id);
}
