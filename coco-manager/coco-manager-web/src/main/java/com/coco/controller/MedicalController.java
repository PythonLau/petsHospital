package com.coco.controller;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.CaseHistory;
import com.coco.pojo.TbPets;
import com.coco.service.MedicalService;
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
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
@Controller
public class MedicalController {
    @Autowired
    private PetService petService;
    @Autowired
    private MedicalService medicalService;
    @RequestMapping("/user/registerMedical/{petId}")
    public String getMedical(@PathVariable String petId, Model model, HttpSession session,
                      HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal pet_Id = new BigDecimal(petId);
        TbPets tbPet = petService.getPet(pet_Id);
        model.addAttribute("pet",tbPet);
        return "/user/registerMedical";
    }
    @RequestMapping("/user/registerMedical")
    public void registerMedical(String id,String cid,String name,String registerTime) throws Exception{
        BigDecimal petId = new BigDecimal(id);
        Long positionCat = Long.parseLong(cid);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        java.util.Date registerDate=sdf.parse(registerTime);
        medicalService.registerMedical(petId,positionCat,name,registerDate);
    }
    @RequestMapping("/user/showMedical/{pageNumber}")
    public String getAdoptMessage(@PathVariable String pageNumber,Model model,HttpSession session,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception{
        String petId = request.getParameter("petId");
        BigDecimal pet_Id = new BigDecimal(petId);
        Integer page_Number = new Integer(pageNumber);
        Page<CaseHistory> caseHistory = medicalService.getCaseHistory(page_Number,pet_Id);
        request.setAttribute("packagePage", caseHistory);
        model.addAttribute("list",caseHistory.getList());
        return "/user/caseHistory";
    }
    @RequestMapping("/user/cancelMedical/{caseHistoryId}")
    public void cancelMedical(@PathVariable String caseHistoryId, HttpSession session,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal caseHistory_Id = new BigDecimal(caseHistoryId);
        BigDecimal petId = medicalService.getPetId(caseHistory_Id);
        TaotaoResult result = medicalService.cancelMedical(caseHistory_Id);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/showMedical/1?petId=" + petId).forward(request,response);
        }
    }
}
