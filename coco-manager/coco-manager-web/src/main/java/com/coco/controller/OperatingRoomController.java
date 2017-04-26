package com.coco.controller;

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
}
