package com.coco.service;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbOrder;
import com.coco.pojo.myOrder;

import java.math.BigDecimal;

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
}
