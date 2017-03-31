package com.coco.controller;

import com.coco.common.pojo.EUTreeNodeWithAttributes;
import com.coco.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
@Controller
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
    @RequestMapping("/report/list")
    @ResponseBody
    public List<EUTreeNodeWithAttributes> getModuleList(@RequestParam(value="id",defaultValue="0")BigDecimal parentId,
                                                        HttpSession session){
        Object userId = session.getAttribute("report");
        BigDecimal user_Id = (BigDecimal)userId;
        List<EUTreeNodeWithAttributes> list = moduleService.getModuleList(parentId,user_Id);
        System.out.println("controller ----list");
        System.out.println(list);
        return list;
    }
}
