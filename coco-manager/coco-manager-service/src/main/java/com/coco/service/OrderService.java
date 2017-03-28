package com.coco.service;

import com.coco.common.pojo.TaotaoResult;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public interface OrderService {
    TaotaoResult bookPackage(BigDecimal packageId,BigDecimal userId);
}
