package com.coco.service.impl;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbOrderMapper;
import com.coco.mapper.TbPackageMapper;
import com.coco.pojo.TbOrder;
import com.coco.pojo.TbOrderExample;
import com.coco.pojo.TbPackage;
import com.coco.pojo.myOrder;
import com.coco.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TbOrderMapper orderMapper;
    @Autowired
    private TbPackageMapper packageMapper;
    @Override
    public TaotaoResult bookPackage(BigDecimal packageId, BigDecimal userId,boolean isVIP){
        BigDecimal ten = new BigDecimal(10);
        Long orderId = IDUtils.genItemId();
        BigDecimal order_Id = new BigDecimal(orderId);
        TbOrder tbOrder = new TbOrder();
        tbOrder.setId(order_Id);
        tbOrder.setPackageId(packageId);
        TbPackage tbPackage = packageMapper.selectByPrimaryKey(packageId);
        BigDecimal originPrice = tbPackage.getPrice();
        if(isVIP){
            BigDecimal discount = tbPackage.getMemberdiscount();
            BigDecimal price = originPrice.multiply(discount).divide(ten,2, RoundingMode.UP);
            tbOrder.setPrice(price);
        }else{
            BigDecimal discount = tbPackage.getNormaldiscount();
            BigDecimal price = originPrice.multiply(discount).divide(ten,2, RoundingMode.UP);
            tbOrder.setPrice(price);
        }
        tbOrder.setUserid(userId);
        Short status = 1;
        tbOrder.setStatus(status);
        tbOrder.setCreated(new Date());
        tbOrder.setUpdated(new Date());
        orderMapper.insert(tbOrder);
        return TaotaoResult.ok();
    }
    @Override
    public Page<myOrder> getMyOrderList(Integer pageNumber,BigDecimal userId){
        Page<myOrder> page = new Page<>(pageNumber);
        TbOrderExample example = new TbOrderExample();
        TbOrderExample.Criteria criteria = example.createCriteria();
        Short zero = 0;
        criteria.andUseridEqualTo(userId);
        criteria.andStatusNotEqualTo(zero);
        Integer count = orderMapper.countByExample(example);
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNumber, page.getPageSize());
        List<myOrder> list = new ArrayList<>();
        List<TbOrder> orderList = orderMapper.selectByExample(example);
        for(TbOrder order : orderList){
            myOrder orderView = new myOrder();
            orderView.setId(order.getId());
            orderView.setPrice(order.getPrice());
            orderView.setScore(order.getScore());
            orderView.setWords(order.getWords());
            orderView.setStatus(order.getStatus());
            TbPackage tbPackage = packageMapper.selectByPrimaryKey(order.getPackageId());
            orderView.setName(tbPackage.getName());
            orderView.setImage(tbPackage.getImage());
            list.add(orderView);
        }
        page.setTotalPageItems(count);
        page.setList(list);
        return page;
    }
    @Override
    public TaotaoResult cancelOrder(BigDecimal orderId){
        TbOrder order = orderMapper.selectByPrimaryKey(orderId);
        Short zero =  0;
        order.setStatus(zero);
        orderMapper.updateByPrimaryKey(order);
        return TaotaoResult.ok();
    }
    @Override
    public TaotaoResult evaluateOrder(BigDecimal orderId){
        return null;
    }
    @Override
    public TbOrder getOrder(BigDecimal orderId){
        TbOrder order = orderMapper.selectByPrimaryKey(orderId);
        return order;
    }
    @Override
    public TaotaoResult evaluateOrder(BigDecimal id,Short score,String words){
        TbOrder order = orderMapper.selectByPrimaryKey(id);
        order.setScore(score);
        order.setWords(words);
        Short three = 3;
        order.setStatus(three);
        orderMapper.updateByPrimaryKey(order);
        return TaotaoResult.ok();
    }
}
