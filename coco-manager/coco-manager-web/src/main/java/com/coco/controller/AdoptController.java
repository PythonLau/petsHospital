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
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        BigDecimal pet_Id = new BigDecimal(petId);
        //判断能不能发起领养申请
        //判断这个宠物是不是自己的
        boolean petBelongToUserFlag = petService.judgePetBelongToUser(user_Id,pet_Id);
        //判断用户有没有申请领养过该宠物
        boolean hadAdoptThePet = adoptService.judgeHadAdoptThePet(user_Id,pet_Id);
        if(petBelongToUserFlag == false && hadAdoptThePet == false){
            TbPets tbPet = petService.getPet(pet_Id);
            model.addAttribute("pet",tbPet);
            return "/user/adoptApply";
        }else if(petBelongToUserFlag){
            //不能领养自己寄养的宠物
            System.out.println("不能领养自己寄养的宠物");
            request.setAttribute("wrong","不能领养自己寄养的宠物");
            request.getRequestDispatcher("/adopt/1").forward(request,response);
        }else if(hadAdoptThePet){
            //已经申请领养了，不能再次申请
            System.out.println("已经申请领养了，不能再次申请");
            request.setAttribute("wrong","已经申请领养了，不能再次申请");
            request.getRequestDispatcher("/adopt/1").forward(request,response);
        }
        return null;
    }
    @RequestMapping("/user/adopt")
    public void adopt(String id, String address, String contacts, String telePhone, HttpSession session,
                       HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean flag = false;
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        BigDecimal petId = new BigDecimal(id);
        TaotaoResult result = adoptService.addAdopt(petId,user_Id,contacts,address,telePhone);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/adoptList/1").forward(request,response);
        }
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
        if(adoptMessage.getList().size() != 0){
            String petName = adoptMessage.getList().get(0).getName();
            request.setAttribute("petName",petName);
        }
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
