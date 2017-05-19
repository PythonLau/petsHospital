package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbMedicalDetail;
import com.coco.pojo.medicalRecord;
import com.coco.service.MedicalDetailService;
import com.coco.service.OperatingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
@Controller
public class MedicalDetailController {
    @Autowired
    private MedicalDetailService medicalDetailService;
    @Autowired
    private OperatingRoomService operatingRoomService;
    @RequestMapping("/doctor/medicalDetail/save")
    @ResponseBody
    public TaotaoResult saveMedicalDetail(TbMedicalDetail medicalDetail){
        Short zero = 0;
        if(medicalDetail.getSickname() == null){
            return TaotaoResult.build(500,"请填写治疗项目名称");
        }
        if(medicalDetail.getStatus() == 2){
            if(medicalDetail.getRoom() == null){
                return TaotaoResult.build(500,"请选择手术室");
            }else{
                Short status = operatingRoomService.getOperatingRoomStatus(medicalDetail.getRoom());
                if(status == zero){
                    return TaotaoResult.build(500,"该手术室已被其他医生选择");
                }
            }
        }
        TaotaoResult result = medicalDetailService.saveMedicalDetail(medicalDetail);
        return result;
    }
    @RequestMapping("/doctor/medicalDetail/{medicalId}")
    @ResponseBody
    public EUDataGridResult getMedicalDetailByDoctor(Integer page,Integer rows,
                                                     @PathVariable String medicalId){
        BigDecimal medical_Id = new BigDecimal(medicalId);
        EUDataGridResult result = medicalDetailService.getMedicalDetailByDoctor(medical_Id,page,rows);
        return result;
    }
    @RequestMapping("/manager/medicalDetail/{medicalId}")
    @ResponseBody
    public EUDataGridResult getMedicalDetailByManager(Integer page,Integer rows,
                                                     @PathVariable String medicalId){
        System.out.println("page:" + page);
        System.out.println("rows:" + rows);
        System.out.println("medicalId:" + medicalId);
        BigDecimal medical_Id = new BigDecimal(medicalId);
        EUDataGridResult result = medicalDetailService.getMedicalDetailByManager(medical_Id,page,rows);
        return result;
    }
    @RequestMapping("/manager/medicalDetail/update")
    @ResponseBody
    public TaotaoResult updateMedicalDetail(TbMedicalDetail medicalDetail){
        TaotaoResult result = medicalDetailService.updateMedicalDetailByManager(medicalDetail);
        return result;
    }
    @RequestMapping("/user/medicalDetail/{pageNumber}")
    public String getMedicalDetailByUser(@PathVariable String pageNumber, Model model, HttpSession session,
                                       HttpServletRequest request, HttpServletResponse response){
        String medicalId = request.getParameter("medicalId");
        BigDecimal medical_Id = new BigDecimal(medicalId);
        Integer page_Number = new Integer(pageNumber);
        Page<medicalRecord> medicalRecord = medicalDetailService.getMedicalRecord(page_Number,medical_Id);
        request.setAttribute("packagePage", medicalRecord);
        model.addAttribute("list",medicalRecord.getList());
        return "/user/medicalRecord";
    }
}
