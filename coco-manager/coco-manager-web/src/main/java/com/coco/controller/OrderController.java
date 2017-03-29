package com.coco.controller;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbOrder;
import com.coco.pojo.myOrder;
import com.coco.service.OrderService;
import com.coco.service.PackageService;
import com.coco.service.UserService;
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
 * Created by Administrator on 2017/3/28 0028.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private PackageService packageService;
    @RequestMapping(value="/user/bookPackage/{packageId}")
    @ResponseBody
    public void bookPackage(@PathVariable String packageId, HttpSession session,
                            HttpServletRequest request, HttpServletResponse response) throws Exception{
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        //判断用户是否为会员
        boolean isVIP = userService.isVIP(user_Id);
        BigDecimal package_Id = new BigDecimal(packageId);
        TaotaoResult result = orderService.bookPackage(package_Id,user_Id,isVIP);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/orderList/1").forward(request,response);
        }
    }
    @RequestMapping(value="/user/orderList/{pageNumber}")
    public String getOrderList(@PathVariable String pageNumber,Model model, HttpSession session,
                             HttpServletRequest request, HttpServletResponse response) throws Exception{
        Object userId = session.getAttribute("user");
        BigDecimal user_Id = (BigDecimal)userId;
        Integer page_Number = new Integer(pageNumber);
        Page<myOrder> order = orderService.getMyOrderList(page_Number,user_Id);
        request.setAttribute("packagePage", order);
        model.addAttribute("list",order.getList());
        return "/user/myOrders";
    }
    @RequestMapping("/user/cancelOrder/{orderId}")
    public void cancelOrder(@PathVariable String orderId,HttpSession session,
                            HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal order_Id = new BigDecimal(orderId);
        TaotaoResult result = orderService.cancelOrder(order_Id);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/orderList/1").forward(request,response);
        }
    }
    @RequestMapping("/user/evaluate/{orderId}")
    public String getOrder(@PathVariable String orderId,Model model,HttpSession session,
                           HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal order_Id = new BigDecimal(orderId);
        TbOrder order = orderService.getOrder(order_Id);
        BigDecimal packageId = order.getPackageId();
        String packageName = packageService.getPackageName(packageId);
        request.setAttribute("packageName",packageName);
        model.addAttribute("order",order);
        return "/user/evaluateOrder";
    }
    @RequestMapping("/user/evaluate")
    public void evaluateOrder(String id,String score,String words,HttpSession session,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception{
        BigDecimal orderId = new BigDecimal(id);
        Short orderScore = new Short(score);
        TaotaoResult result = orderService.evaluateOrder(orderId,orderScore,words);
        if(result.getStatus() == 200){
            request.getRequestDispatcher("/user/orderList/1").forward(request,response);
        }
    }
}
