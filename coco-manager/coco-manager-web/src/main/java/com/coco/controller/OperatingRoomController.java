package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNode;
import com.coco.service.OperatingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
@Controller
public class OperatingRoomController {
    @Autowired
    private OperatingRoomService operatingRoomService;
    @RequestMapping("/doctor/operatingRoom/list")
    @ResponseBody
    public List<EUTreeNode> getOperatingRoomList(@RequestParam(value="id",defaultValue="0")BigDecimal parentId){
        List<EUTreeNode> list = operatingRoomService.getOperatingRoomList(parentId);
        return list;
    }
    @RequestMapping("/manager/room/tree")
    @ResponseBody
    public List<EUTreeNode> getRoomTreeByManager(@RequestParam(value="id",defaultValue="0")BigDecimal parentId){
        List<EUTreeNode> list = operatingRoomService.getRoomTreeListByManager(parentId);
        return list;
    }
    @RequestMapping("/manager/room/list")
    @ResponseBody
    public EUDataGridResult getRoomListByManager(Integer page,Integer rows){
        EUDataGridResult result = operatingRoomService.getRoomListByManager(page,rows);
        return result;
    }
}
