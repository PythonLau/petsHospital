package com.coco.controller;

import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbPets;
import com.coco.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27 0027.
 */
@Controller
public class PetController {
    @Autowired
    private PetService petService;
    @RequestMapping(value = "/user/addPet",method = RequestMethod.POST)
    public void addPet(String petName, String typeName, String petAge,
                       String petSex, String image, HttpSession session,
                       HttpServletRequest request, HttpServletResponse response) throws Exception{
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        Short pet_Age = new Short(petAge);
        TaotaoResult result = petService.addPet(user_Id,petName,typeName,pet_Age,petSex,image);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/myPets").forward(request,response);
        }else if(result.getStatus() == 500){
            request.setAttribute("addPetFail","新增宠物失败,请重新填写");
            request.getRequestDispatcher("/user/addPets").forward(request,response);
        }
    }
    @RequestMapping("/user/petsList")
    public String getPetList(Model model, HttpSession session,
                           HttpServletRequest request, HttpServletResponse response){
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        List<TbPets> list = petService.getPetList(user_Id);
        model.addAttribute("list",list);
        return "/user/myPets";
    }
}
