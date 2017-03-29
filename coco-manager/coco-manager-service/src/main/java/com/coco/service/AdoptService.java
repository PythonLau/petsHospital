package com.coco.service;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.myAdopt;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
public interface AdoptService {
    TaotaoResult addAdopt(BigDecimal petId, BigDecimal userId,String address, String telePhone);
    Page<myAdopt> getMyAdoptList(Integer pageNumber, BigDecimal userId);
    TaotaoResult cancelAdopt(BigDecimal id);
}
