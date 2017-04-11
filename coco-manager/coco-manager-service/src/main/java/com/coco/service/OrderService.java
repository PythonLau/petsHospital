package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbOrder;
import com.coco.pojo.myOrder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public interface OrderService {
    TaotaoResult bookPackage(BigDecimal packageId,BigDecimal userId,boolean isVIP);
    Page<myOrder> getMyOrderList(Integer pageNumber,BigDecimal userId);
    TaotaoResult cancelOrder(BigDecimal orderId);
    TaotaoResult evaluateOrder(BigDecimal orderId);
    TbOrder getOrder(BigDecimal orderId);
    TaotaoResult evaluateOrder(BigDecimal id,Short score,String words);
    EUDataGridResult getOrderList(Integer page, Integer rows);
    EUDataGridResult searchWithKeyOnly(String search_condition,String search_key, Integer page,Integer rows);
    EUDataGridResult searchWithTimeOnly(Date beginDate, Date endDate, Integer page, Integer rows);
    EUDataGridResult searchWithKeyAndTime(String search_condition,String search_key,
                                                 Date beginDate,Date endDate,Integer page,Integer rows);
    TaotaoResult updateOrder(TbOrder order);
}
