package com.coco.controller;

import com.coco.pojo.TbUser;
import com.coco.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/userLogin/loginConfirm")
    public void managerLoginConfirm(String username, String password, HttpSession session,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("come in userLoginConfirm");
        System.out.println(username);
        System.out.println(password);
        String md5Password = DigestUtils.md5Hex(password);
        TbUser loginUser = userService.selectLoginUser(username,md5Password);
        if(loginUser == null){
            request.setAttribute("wrong","账号或密码有误");
            request.getRequestDispatcher("/login").forward(request,response);
        }else{
            BigDecimal userId = loginUser.getId();
            Short userStatus = loginUser.getStatus();
            System.out.println(md5Password);
            session.setAttribute("user",userId);
            session.setAttribute("userStatus",userStatus);
            response.sendRedirect("/index");
        }
    }
}
