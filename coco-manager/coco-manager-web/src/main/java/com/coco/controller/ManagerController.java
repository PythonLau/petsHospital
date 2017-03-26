package com.coco.controller;

import com.coco.common.pojo.TaotaoResult;
import com.coco.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @RequestMapping(value="/managerLogin/loginConfirm",method= RequestMethod.POST)
    @ResponseBody
    public void managerLoginConfirm(String username, String password, HttpSession session,
                                    HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("come in loginConfirm");
        System.out.println(username);
        System.out.println(password);
        String md5Password = DigestUtils.md5Hex(password);
        boolean isManagerExist = managerService.IsManagerExist(username,md5Password);
        if(isManagerExist){
            System.out.println(md5Password);
            session.setAttribute("admin","username");
            response.sendRedirect("/manager/index");
        }else{
            request.setAttribute("wrong","账号或者密码错误");
            request.getRequestDispatcher("/manager/login").forward(request,response);
        }
    }
}
