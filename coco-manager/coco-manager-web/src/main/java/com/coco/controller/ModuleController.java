package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNodeWithAttributes;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.pojo.search_params;
import com.coco.pojo.TbModule;
import com.coco.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("/manager/module/list")
    @ResponseBody
    public List<EUTreeNodeWithAttributes> getModuleListByManager(@RequestParam(value="id",defaultValue="0")BigDecimal parentId,
                                                        HttpSession session){
        List<EUTreeNodeWithAttributes> list = moduleService.getModuleListByManager(parentId);
        return list;
    }
    @RequestMapping("/manager/module/create")
    @ResponseBody
    public TaotaoResult createModule(BigDecimal parentId, String name){
        TaotaoResult result = moduleService.createModule(parentId,name);
        return result;
    }
    @RequestMapping("/manager/module/update")
    @ResponseBody
    public TaotaoResult updateModule(BigDecimal id,String name){
        TaotaoResult result = moduleService.updateModule(id,name);
        return result;
    }
    @RequestMapping("/manager/module/delete")
    @ResponseBody
    public TaotaoResult deleteModule(BigDecimal id){
        TaotaoResult result = moduleService.deleteModule(id);
        return result;
    }
    @RequestMapping("/manager/module/edit/list")
    @ResponseBody
    public EUDataGridResult getModuleEditList(Integer page, Integer rows){
        EUDataGridResult result = moduleService.getModuleEditList(page,rows);
        return result;
    }
    @RequestMapping("/manager/module/detail/update")
    @ResponseBody
    public TaotaoResult updateModuleDetail(TbModule module){
        TaotaoResult result = moduleService.updateModuleDetail(module);
        return result;
    }
    @RequestMapping("/manager/Module/search")
    @ResponseBody
    public EUDataGridResult searchModule(@RequestBody search_params search_params) throws Exception{
        String name = search_params.getSearch_key();
        Integer page = new Integer(search_params.getPageNumber());
        Integer rows = new Integer(search_params.getRows());
        EUDataGridResult result = moduleService.searchModule(name,page,rows);
        return result;
    }
}
