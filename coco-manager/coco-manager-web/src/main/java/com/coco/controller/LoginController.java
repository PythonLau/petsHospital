package com.coco.controller;

import com.coco.pojo.TbLogin;
import com.coco.service.LoginService;
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
 * Created by Administrator on 2017/3/31 0031.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value="/reportLogin/loginConfirm",method= RequestMethod.POST)
    @ResponseBody
    public void managerLoginConfirm(String username, String password, HttpSession session,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception{
        String md5Password = DigestUtils.md5Hex(password);
        TbLogin loginUser = loginService.getUser(username,md5Password);
        if(loginUser == null){
            request.setAttribute("wrong","账号或者密码错误");
            request.getRequestDispatcher("/report/login").forward(request,response);
        }else{
            session.setAttribute("report",loginUser.getId());
            session.setAttribute("reportStatus",loginUser.getStatus());
            response.sendRedirect("/report/index");
        }
    }

}
