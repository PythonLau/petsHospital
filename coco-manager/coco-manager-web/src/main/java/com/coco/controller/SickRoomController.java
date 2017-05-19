package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;
import com.coco.service.SickRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/4/23 0023.
 */
@Controller
public class SickRoomController {
    @Autowired
    private SickRoomService sickRoomService;
    @RequestMapping("/doctor/bedRoom/list")
    @ResponseBody
    public List<EUTreeNode> getBedRoomList(@RequestParam(value="id",defaultValue="0")BigDecimal parentId){
        List<EUTreeNode> list = sickRoomService.getBedRoomListByDoctor(parentId);
        return list;
    }
    @RequestMapping("/manager/bed/tree")
    @ResponseBody
    public List<EUTreeNode> getBedTreeByManager(@RequestParam(value="id",defaultValue="0")BigDecimal parentId){
        List<EUTreeNode> list = sickRoomService.getBedTreeByManager(parentId);
        return list;
    }
    @RequestMapping("/manager/bed/list")
    @ResponseBody
    public EUDataGridResult getBedListByManager(Integer page,Integer rows){
        EUDataGridResult result = sickRoomService.getBedListByManager(page,rows);
        return result;
    }
    @RequestMapping("/manager/bed/create")
    @ResponseBody
    public TaotaoResult createBed(BigDecimal parentId, String name){
        TaotaoResult result = sickRoomService.createBed(parentId,name);
        return result;
    }
    @RequestMapping("/manager/bed/update")
    @ResponseBody
    public TaotaoResult updateBed(BigDecimal id,String name){
        TaotaoResult result = sickRoomService.updateBed(id,name);
        return result;
    }
    @RequestMapping("/manager/bed/delete")
    @ResponseBody
    public TaotaoResult deleteBed(BigDecimal id){
        TaotaoResult result = sickRoomService.deleteBed(id);
        return result;
    }
}
