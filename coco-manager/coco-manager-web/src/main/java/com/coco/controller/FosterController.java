package com.coco.controller;

import com.coco.common.pojo.TaotaoResult;
import com.coco.service.FosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
@Controller
public class FosterController {
    @Autowired
    private FosterService fosterService;
    @RequestMapping("/user/foster")
    public void foster(String id, String address, String telePhone, HttpSession session,
                       HttpServletRequest request, HttpServletResponse response) throws Exception{
        TaotaoResult result = fosterService.addFoster(id,address,telePhone);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/petsList").forward(request,response);
        }
    }
}
