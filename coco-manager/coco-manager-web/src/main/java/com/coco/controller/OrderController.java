package com.coco.controller;

import com.coco.common.pojo.TaotaoResult;
import com.coco.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value="/user/bookPackage/{packageId}")
    @ResponseBody
    public void bookPackage(@PathVariable String packageId, HttpSession session) throws Exception{
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        BigDecimal package_Id = new BigDecimal(packageId);
        TaotaoResult result = orderService.bookPackage(package_Id,user_Id);
        
    }
}
