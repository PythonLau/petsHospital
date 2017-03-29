package com.coco.service;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.AdoptMessage;
import com.coco.pojo.myAdopt;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
public interface AdoptService {
    TaotaoResult addAdopt(BigDecimal petId, BigDecimal userId,String address, String telePhone);
    Page<myAdopt> getMyAdoptList(Integer pageNumber, BigDecimal userId);
    TaotaoResult cancelAdopt(BigDecimal id);
    Page<AdoptMessage> getAdoptMessage(Integer pageNumber,BigDecimal petId);
}
