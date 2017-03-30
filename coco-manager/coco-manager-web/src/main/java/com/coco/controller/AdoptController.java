package com.coco.controller;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.AdoptMessage;
import com.coco.pojo.TbPets;
import com.coco.pojo.myAdopt;
import com.coco.service.AdoptService;
import com.coco.service.PetService;
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
 * Created by Administrator on 2017/3/29 0029.
 */
@Controller
public class AdoptController {
    @Autowired
    private PetService petService;
    @Autowired
    private AdoptService adoptService;
    @RequestMapping("/user/adoptApply/{petId}")
    public String getFosterPet(@PathVariable String petId, Model model, HttpSession session,
                               HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal pet_Id = new BigDecimal(petId);
        TbPets tbPet = petService.getPet(pet_Id);
        model.addAttribute("pet",tbPet);
        return "/user/adoptApply";
    }
    @RequestMapping("/user/adopt")
    public void adopt(String id, String address, String telePhone, HttpSession session,
                       HttpServletRequest request, HttpServletResponse response) throws Exception{
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        BigDecimal petId = new BigDecimal(id);
        adoptService.addAdopt(petId,user_Id,address,telePhone);
    }
    @RequestMapping(value="/user/adoptList/{pageNumber}")
    public String getOrderList(@PathVariable String pageNumber,Model model, HttpSession session,
                               HttpServletRequest request, HttpServletResponse response) throws Exception{
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        Integer page_Number = new Integer(pageNumber);
        Page<myAdopt> adopt = adoptService.getMyAdoptList(page_Number,user_Id);
        request.setAttribute("packagePage", adopt);
        model.addAttribute("list",adopt.getList());
        return "/user/myAdopt";
    }
    @RequestMapping("/user/cancelAdopt/{adoptId}")
    public void cancelAdopt(@PathVariable String adoptId,HttpSession session,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal adopt_Id = new BigDecimal(adoptId);
        TaotaoResult result = adoptService.cancelAdopt(adopt_Id);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/adoptList/1").forward(request,response);
        }
    }
    @RequestMapping("/user/getAdoptMessage/{pageNumber}")
    public String getAdoptMessage(@PathVariable String pageNumber,Model model,HttpSession session,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception{
        String petId = request.getParameter("petId");
        BigDecimal pet_Id = new BigDecimal(petId);
        Integer page_Number = new Integer(pageNumber);
        Page<AdoptMessage> adoptMessage = adoptService.getAdoptMessage(page_Number,pet_Id);
        request.setAttribute("packagePage", adoptMessage);
        model.addAttribute("list",adoptMessage.getList());
        return "/user/adoptMessage";
    }
    @RequestMapping("/user/agreeAdopt/{adoptId}")
    public void agreeAdopt(@PathVariable String adoptId,HttpSession session,
                           HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal adopt_Id = new BigDecimal(adoptId);
        TaotaoResult result = adoptService.agreeAdopt(adopt_Id);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/petsList").forward(request,response);
        }
    }
}
