package com.coco.controller;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbPets;
import com.coco.service.FosterService;
import com.coco.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
            request.getRequestDispatcher("/user/petsList").forward(request,response);
        }else if(result.getStatus() == 500){
            request.setAttribute("addPetFail","新增宠物失败,请重新填写");
            request.getRequestDispatcher("/user/addPets").forward(request,response);
        }
    }
    @RequestMapping("/user/petsList/{pageNumber}")
    public String getPetList(@PathVariable String pageNumber,Model model, HttpSession session,
                           HttpServletRequest request, HttpServletResponse response){
        Integer page_number = new Integer(pageNumber);
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        Page<TbPets> pets = petService.getPetList(page_number,user_Id);
        request.setAttribute("packagePage",pets);
        System.out.println("petList");
        model.addAttribute("list",pets.getList());
        return "/user/myPets";
    }
    @RequestMapping("/user/deletePet/{petId}")
    public void deletePet(@PathVariable String petId,HttpSession session,
                            HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal pet_Id = new BigDecimal(petId);
        TaotaoResult result = petService.deletePet(pet_Id);
        if(result.getStatus() == 200){
            System.out.println("deletePet");
            request.getRequestDispatcher("/user/petsList/1").forward(request,response);
        }
    }
    @RequestMapping("/user/getPet/{petId}")
    public String getPet(@PathVariable String petId,Model model,HttpSession session,
                         HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal pet_Id = new BigDecimal(petId);
        TbPets tbPet = petService.getPet(pet_Id);
        model.addAttribute("pet",tbPet);
        return "/user/editPet";
    }
    @RequestMapping("/user/editPet")
    public void editPet(String id,String petName, String typeName, String petAge,
                       String petSex, String image, HttpSession session,
                       HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal pet_Id = new BigDecimal(id);
        Short pet_Age = new Short(petAge);
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        System.out.println(user_Id);
        TaotaoResult result = petService.editPet(pet_Id,petName,typeName,user_Id,pet_Age,petSex,image);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/petsList").forward(request,response);
        }
    }
    @RequestMapping("/user/editPetFail")
    public String editPetFail(String id,Model model,HttpSession session, HttpServletRequest request,
                             HttpServletResponse response) throws Exception{
        request.setAttribute("editPetFail","修改信息有误,请重新填写");
        System.out.println(id);
        BigDecimal pet_Id = new BigDecimal(id);
        TbPets tbPet = petService.getPet(pet_Id);
        model.addAttribute("pet",tbPet);
        return "/user/editPet";
    }
    @RequestMapping("/user/foster/{petId}")
    public String getFosterPet(@PathVariable String petId,Model model,HttpSession session,
                         HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal pet_Id = new BigDecimal(petId);
        TbPets tbPet = petService.getPet(pet_Id);
        model.addAttribute("pet",tbPet);
        return "/user/foster";
    }
}
