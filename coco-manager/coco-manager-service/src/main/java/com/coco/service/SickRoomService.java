package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/4/23 0023.
 */
public interface SickRoomService {
    List<EUTreeNode> getBedRoomListByDoctor(BigDecimal parentId);
    Short getSickRoomStatus(BigDecimal sickRoomId);
    List<EUTreeNode> getBedTreeByManager(BigDecimal parentId);
    EUDataGridResult getBedListByManager(Integer page,Integer rows);
    TaotaoResult createBed(BigDecimal parentId, String name);
    TaotaoResult updateBed(BigDecimal id,String name);
    TaotaoResult deleteBed(BigDecimal id);
    boolean judgeDeleteBed(BigDecimal id);
}
