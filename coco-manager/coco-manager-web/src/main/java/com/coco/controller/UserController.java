package com.coco.controller;

import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbUser;
import com.coco.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public void userLoginConfirm(String username, String password, HttpSession session,
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
            String nickName = loginUser.getNickname();
            Short userStatus = loginUser.getStatus();
            System.out.println(md5Password);
            session.setAttribute("user",userId);
            session.setAttribute("nickName",nickName);
            session.setAttribute("userStatus",userStatus);
            response.sendRedirect("/index");
        }
    }
    @RequestMapping(value = "/register/checkRegisterName",method=RequestMethod.POST)
    @ResponseBody
    public String checkRegisterName(String registerName){
        boolean isRegisterNameExist = userService.checkRegisterName(registerName);
        String result = String.valueOf(isRegisterNameExist);
        return result;
    }
    @RequestMapping(value = "/register/checkNickName",method = RequestMethod.POST)
    @ResponseBody
    public String checkNickName(String registerNickName){
        boolean isRegisterNickName = userService.checkRegisterNickName(registerNickName);
        String result = String.valueOf(isRegisterNickName);
        return result;
    }
    @RequestMapping("/register/userRegister")
    public void userRegister(String registerUserName,String registerPassWord,
                        String nickName,String telePhone, HttpSession session,
                             HttpServletRequest request, HttpServletResponse response) throws Exception{
        String md5Password = DigestUtils.md5Hex(registerPassWord);
        TaotaoResult result = userService.userRegister(registerUserName,md5Password,nickName,telePhone);
        if(result.getStatus() == 200){
            request.setAttribute("registerSuccess","注册成功，现在可以登陆系统进行业务操作了");
            request.getRequestDispatcher("/login").forward(request,response);
        }else if(result.getStatus() == 500){
            request.setAttribute("registerFail","注册失败，请重新填写注册信息");
            request.getRequestDispatcher("/register").forward(request,response);
        }
    }
}
