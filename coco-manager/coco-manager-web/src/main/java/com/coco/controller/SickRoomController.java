package com.coco.controller;

import com.coco.common.pojo.EUTreeNode;
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
}
