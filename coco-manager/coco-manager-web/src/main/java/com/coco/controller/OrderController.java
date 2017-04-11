package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.pojo.searchParamsWithTime;
import com.coco.pojo.TbOrder;
import com.coco.pojo.myOrder;
import com.coco.service.OrderService;
import com.coco.service.PackageService;
import com.coco.service.UserService;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    @RequestMapping("/manager/order/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows) {
        EUDataGridResult result = orderService.getOrderList(page, rows);
        return result;
    }
    @RequestMapping("/manager/order/search")
    @ResponseBody
    public EUDataGridResult searchOrder(@RequestBody searchParamsWithTime search_params) throws Exception{
        String search_condition = search_params.getSearch_condition();
        String search_key = search_params.getSearch_key();
        Date beginDate = search_params.getBeginDate();
        Date endDate = search_params.getEndDate();
        Integer page = Integer.valueOf(search_params.getPageNumber());
        Integer rows = Integer.valueOf(search_params.getRows());
        if(search_key.length() == 0 && (beginDate == null || endDate == null)){
            //两个条件都没有，不用查
            return null;
        }else if(search_key.length() != 0){
            if((beginDate == null || endDate == null)){
                //直接查只有关键词的方法
                EUDataGridResult result = orderService.searchWithKeyOnly(search_condition,search_key,page,rows);
                return result;
            }else{
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(beginDate);
                calendar.add(Calendar.HOUR,-8);
                beginDate = calendar.getTime();
                calendar.setTime(endDate);
                calendar.add(Calendar.HOUR,-8);
                endDate = calendar.getTime();
                System.out.println("2222222");
                //查询考虑关键词和时间并存的方法
                EUDataGridResult result = orderService.searchWithKeyAndTime(search_condition,search_key,beginDate,endDate,page,rows);
                return result;
            }
        }else{
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(beginDate);
            calendar.add(Calendar.HOUR,-8);
            beginDate = calendar.getTime();
            calendar.setTime(endDate);
            calendar.add(Calendar.HOUR,-8);
            endDate = calendar.getTime();
            //查询只有时间的方法
            System.out.println("111111");
            System.out.println("开始时间:" + beginDate);
            System.out.println("结束时间:" + endDate);
            EUDataGridResult result = orderService.searchWithTimeOnly(beginDate,endDate,page,rows);
            return result;
        }
    }
    @RequestMapping("/manager/order/update")
    @ResponseBody
    public TaotaoResult updateOrder(TbOrder order) throws Exception{
        TaotaoResult result = orderService.updateOrder(order);
        return result;
    }
}
