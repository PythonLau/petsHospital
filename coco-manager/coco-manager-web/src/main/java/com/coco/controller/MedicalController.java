package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.pojo.searchParamsWithTime;
import com.coco.pojo.CaseHistory;
import com.coco.pojo.TbMedical;
import com.coco.pojo.TbPets;
import com.coco.service.MedicalService;
import com.coco.service.PetService;
import com.coco.service.SickRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
@Controller
public class MedicalController {
    @Autowired
    private PetService petService;
    @Autowired
    private MedicalService medicalService;
    @Autowired
    private SickRoomService sickRoomService;
    @RequestMapping("/user/registerMedical/{petId}")
    public String getMedical(@PathVariable String petId, Model model, HttpSession session,
                      HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal pet_Id = new BigDecimal(petId);
        TbPets tbPet = petService.getPet(pet_Id);
        model.addAttribute("pet",tbPet);
        return "/user/registerMedical";
    }
    @RequestMapping("/user/registerMedical")
    public void registerMedical(String id,String cid,String name,String registerTime,
                                HttpSession session, HttpServletRequest request,
                                HttpServletResponse response) throws Exception{
        BigDecimal petId = new BigDecimal(id);
        Long positionCat = Long.parseLong(cid);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        java.util.Date registerDate=sdf.parse(registerTime);
        TaotaoResult result = medicalService.registerMedical(petId,positionCat,name,registerDate);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/showMedical/1?petId=" + petId).forward(request,response);
        }
    }
    @RequestMapping("/user/showMedical/{pageNumber}")
    public String getCaseHistory(@PathVariable String pageNumber,Model model,HttpSession session,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception{
        String petId = request.getParameter("petId");
        BigDecimal pet_Id = new BigDecimal(petId);
        Integer page_Number = new Integer(pageNumber);
        Page<CaseHistory> caseHistory = medicalService.getCaseHistory(page_Number,pet_Id);
        request.setAttribute("packagePage", caseHistory);
        model.addAttribute("list",caseHistory.getList());
        if(caseHistory.getList().size() != 0){
            String petName = caseHistory.getList().get(0).getPetName();
            request.setAttribute("petName",petName);
        }
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
    @RequestMapping("/doctor/treat/list")
    @ResponseBody
    public EUDataGridResult getTreatList(Integer page, Integer rows,HttpSession session,
                                            HttpServletRequest request, HttpServletResponse response) {
        System.out.println("treatList...controller");
        Object userId = session.getAttribute("doctor");
        BigDecimal user_Id = (BigDecimal)userId;
        EUDataGridResult result = medicalService.getTreatList(page,rows,user_Id);
        return result;
    }

    @RequestMapping("/doctor/medical/accept")
    @ResponseBody
    public TaotaoResult acceptMedical(TbMedical medical, HttpSession session,
                                      HttpServletRequest request, HttpServletResponse response){
        Object userId = session.getAttribute("doctor");
        BigDecimal user_Id = (BigDecimal)userId;
        Short zero = 0;
        if(medical.getSickname() == null){
            return TaotaoResult.build(500,"请填写宠物病因");
        }
        if(medical.getStatus() == 3){
            if(medical.getBedroom() == null){
                return TaotaoResult.build(500,"请选择床位");
            }else{
                Short status = sickRoomService.getSickRoomStatus(medical.getBedroom());
                if(status == zero){
                    return TaotaoResult.build(500,"该床位已被其他医生选择");
                }
            }
        }
        medical.setDoctorid(user_Id);
        TaotaoResult result = medicalService.acceptMedical(medical);
        return result;
    }

    @RequestMapping("/doctor/prescribe/list")
    @ResponseBody
    public EUDataGridResult getDoctorMedicalList(Integer page,Integer rows,HttpSession session,
                                                 HttpServletRequest request, HttpServletResponse response){
        Object userId = session.getAttribute("doctor");
        BigDecimal user_Id = (BigDecimal)userId;
        //查询商品列表
        EUDataGridResult result = medicalService.getMedicalListByDoctor(page,rows,user_Id);
        return result;
    }

    @RequestMapping("/doctor/medical/{medicalId}")
    public void getMedicalDetailUrlByDoctor(@PathVariable String medicalId, HttpSession session,
                     HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("test : " + medicalId);
        String url = "/doctor/medicalDetail/" + medicalId;
        request.setAttribute("url",url);
        request.getRequestDispatcher("/doctor/medicalDetail-list").forward(request,response);
    }
    @RequestMapping("/manager/medical/{medicalId}")
    public void getMedicalDetailUrlByManager(@PathVariable String medicalId, HttpSession session,
                                            HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("test : " + medicalId);
        String url = "/manager/medicalDetail/" + medicalId;
        request.setAttribute("url",url);
        request.getRequestDispatcher("/manager/medicalDetail-list").forward(request,response);
    }
    @RequestMapping("/manager/medical/list")
    @ResponseBody
    public EUDataGridResult getMedicalOrderList(Integer page, Integer rows){
        EUDataGridResult result = medicalService.getMedicalOrderList(page, rows);
        return result;
    }
    @RequestMapping("/manager/medical/update")
    @ResponseBody
    public TaotaoResult updateMedicalByManager(TbMedical medical) throws Exception{
        TaotaoResult result = medicalService.updateMedicalByManager(medical);
        return result;
    }
    @RequestMapping("/manager/medical/search")
    @ResponseBody
    public EUDataGridResult searchMedicalByManager(@RequestBody searchParamsWithTime search_params) throws Exception {
        if(search_params.getSearch_key().length() == 0 && (search_params.getBeginDate() == null || search_params.getEndDate() == null)){
            return null;
        }else{
            EUDataGridResult result = medicalService.searchMedicalByManager(search_params);
            return result;
        }
    }
    @RequestMapping("/doctor/medical/search")
    @ResponseBody
    public EUDataGridResult searchMedicalByDoctor(@RequestBody searchParamsWithTime search_params,HttpSession session,
                                                  HttpServletRequest request, HttpServletResponse response) throws Exception{
        Object userId = session.getAttribute("doctor");
        BigDecimal user_Id = (BigDecimal)userId;
        String search_key = search_params.getSearch_key();
        Date beginDate = search_params.getBeginDate();
        Date endDate = search_params.getEndDate();
        System.out.println(search_key.length());
        System.out.println(beginDate == null || endDate == null);
        if(search_key.length() == 0 && (beginDate == null || endDate == null)){
            System.out.println("返回null");
            return null;
        }else{
            EUDataGridResult result = medicalService.searchMedicalByDoctor(search_params,user_Id);
            return result;
        }
    }
    @RequestMapping("/doctor/treat/search")
    @ResponseBody
    public EUDataGridResult searchTreatByDoctor(@RequestBody searchParamsWithTime search_params,HttpSession session,
                                                HttpServletRequest request, HttpServletResponse response) throws Exception{
        Object userId = session.getAttribute("doctor");
        BigDecimal user_Id = (BigDecimal)userId;
        if(search_params.getSearch_key().length() == 0 && (search_params.getBeginDate() == null || search_params.getEndDate() == null)){
            return null;
        }else{
            EUDataGridResult result = medicalService.searchTreatByDoctor(search_params,user_Id);
            return result;
        }
    }
    @RequestMapping("/doctor/medical/update")
    @ResponseBody
    public TaotaoResult updateMedicalByDoctor(TbMedical medical){
        Short zero = 0;
        if(medical.getSickname() == null){
            return TaotaoResult.build(500,"请填写宠物病因");
        }
        if(medical.getStatus() == 3){
            if(medical.getBedroom() == null){
                System.out.println("11111111");
                return TaotaoResult.build(500,"请选择床位");
            }else{
                boolean IsChange = medicalService.IsChangeBedRoom(medical);
                if(!IsChange){
                    Short status = sickRoomService.getSickRoomStatus(medical.getBedroom());
                    if(status == zero){
                        return TaotaoResult.build(500,"该床位已被其他医生选择");
                    }
                }
            }
        }
        TaotaoResult result = medicalService.updateMedicalByDoctor(medical);
        return result;
    }
    @RequestMapping("/user/evaluateMedical/{caseHistoryId}")
    public String getOrder(@PathVariable String caseHistoryId,Model model,HttpSession session,
                           HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal caseHistory_Id = new BigDecimal(caseHistoryId);
        TbMedical medical = medicalService.getMedicalById(caseHistory_Id);
        String sickName = medical.getSickname();
        request.setAttribute("sickName",sickName);
        model.addAttribute("medical",medical);
        return "/user/evaluateMedical";
    }
    @RequestMapping("/user/evaluateMedical")
    public void evaluateMedical(String id,String words,HttpSession session,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal medicalId = new BigDecimal(id);
        BigDecimal petId = medicalService.getPetId(medicalId);
        TaotaoResult result = medicalService.evaluateMedical(medicalId,words);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/showMedical/1?petId=" + petId).forward(request,response);
        }
    }
}
