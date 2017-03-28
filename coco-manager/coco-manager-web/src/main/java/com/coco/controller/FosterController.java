package com.coco.controller;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbPackage;
import com.coco.pojo.adoptPet;
import com.coco.service.FosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
@Controller
public class FosterController {
    @Autowired
    private FosterService fosterService;
    @RequestMapping("/user/foster")
    public void foster(String id, String address, String telePhone, HttpSession session,
                       HttpServletRequest request, HttpServletResponse response) throws Exception{
        TaotaoResult result = fosterService.addFoster(id,address,telePhone);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/petsList").forward(request,response);
        }
    }
    @RequestMapping("/user/upFoster/{id}")
    public void upFoster(@PathVariable String id, HttpSession session,
                         HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal petId = new BigDecimal(id);
        TaotaoResult result = fosterService.upFoster(petId);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/petsList").forward(request,response);
        }
    }
    @RequestMapping("/adopt/{pageNumber}")
    public String getAdoptList(@PathVariable String pageNumber,Model model,HttpServletRequest request){
        Integer page_Number = new Integer(pageNumber);
        Page<adoptPet> adoptPet = fosterService.getAdoptList(page_Number);
        request.setAttribute("packagePage", adoptPet);
        model.addAttribute("list",adoptPet.getList());
        return "adopt";
    }
}
