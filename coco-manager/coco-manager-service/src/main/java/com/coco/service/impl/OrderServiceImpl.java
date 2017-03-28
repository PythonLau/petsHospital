package com.coco.service.impl;

import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbOrderMapper;
import com.coco.pojo.TbOrder;
import com.coco.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TbOrderMapper orderMapper;
    public TaotaoResult bookPackage(BigDecimal packageId, BigDecimal userId){
        Long orderId = IDUtils.genItemId();
        BigDecimal order_Id = new BigDecimal(orderId);
        TbOrder tbOrder = new TbOrder();
        tbOrder.setId(order_Id);
        tbOrder.setPackageId(packageId);
        tbOrder.setUserid(userId);
        Short status = 1;
        tbOrder.setStatus(status);
        tbOrder.setCreated(new Date());
        tbOrder.setUpdated(new Date());
        orderMapper.insert(tbOrder);
        return TaotaoResult.ok();
    }
}
