package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbPackage;
import com.coco.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
@Controller
public class PackageController {
    @Autowired
    private PackageService packageService;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping(value="/package/save", method=RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createPackage(TbPackage tbPackage) throws Exception {
        TaotaoResult result = packageService.createPackage(tbPackage);
        return result;
    }
    @RequestMapping("/package/{pageNumber}")
    public String getPackageList(@PathVariable String pageNumber,Model model){
        Integer page_Number = new Integer(pageNumber);
        Page<TbPackage> packagePage = packageService.getTbPackageList(page_Number);
        request.setAttribute("packagePage", packagePage);
        model.addAttribute("list",packagePage.getList());
        return "package";
    }
    @RequestMapping("/package/list")
    @ResponseBody
    public EUDataGridResult getAllPackageList(Integer page, Integer rows){
        System.out.println(page);
        System.out.println(rows);
        System.out.println("packagelist...controller");
        EUDataGridResult result = packageService.getAllTbPackageList(page,rows);
        return result;
    }
    @RequestMapping(value="/package/update",method=RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updatePackage(TbPackage tbPackage) throws Exception{
        TaotaoResult result = packageService.updatePackage(tbPackage);
        return result;
    }
}
