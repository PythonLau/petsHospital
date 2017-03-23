package com.coco.controller;

import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;
import com.coco.service.PositionCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
@Controller
@RequestMapping("/position/cat")
public class PositionCatController {

    @Autowired
    private PositionCatService positionCatService;

    @RequestMapping("/list")
    @ResponseBody
    private List<EUTreeNode> getCatList(@RequestParam(value="id",defaultValue="0")Long parentId) {
        System.out.println("controller..../list");
        System.out.println(parentId);
        List<EUTreeNode> list = positionCatService.getCatList(parentId);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult addTbPositionCat(Long parentId, String name) {
        System.out.println("controller..../create");
        TaotaoResult result = positionCatService.insertPositionCat(parentId, name);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateTbPositionCat(Long id,String name) {
        System.out.println("controller..../update");
        TaotaoResult result = positionCatService.updatePositionCat(id,name);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteTbPositionCat(Long id) {
        System.out.println("controller..../delete");
        TaotaoResult result = positionCatService.deletePositionCat(id);
        return result;
    }
}
