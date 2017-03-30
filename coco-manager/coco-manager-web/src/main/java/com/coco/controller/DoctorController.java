package com.coco.controller;

import com.coco.pojo.TbDoctor;
import com.coco.service.DoctorService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @RequestMapping(value="/doctorLogin/loginConfirm",method= RequestMethod.POST)
    @ResponseBody
    public void doctorLoginConfirm(String username, String password, HttpSession session,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception{
        String md5Password = DigestUtils.md5Hex(password);
        TbDoctor doctor = doctorService.getDoctor(username,md5Password);
        if(doctor == null){
            request.setAttribute("wrong","账号或者密码错误");
            request.getRequestDispatcher("/doctor/login").forward(request,response);
        }else{
            session.setAttribute("doctor",doctor.getId());
            response.sendRedirect("/doctor/index");
        }
    }
}
