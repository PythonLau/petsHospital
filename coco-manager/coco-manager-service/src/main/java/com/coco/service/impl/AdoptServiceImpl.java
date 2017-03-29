package com.coco.service.impl;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbAdoptMapper;
import com.coco.mapper.TbFosterMapper;
import com.coco.mapper.TbPetsMapper;
import com.coco.pojo.*;
import com.coco.service.AdoptService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
@Service
public class AdoptServiceImpl implements AdoptService {
    @Autowired
    private TbAdoptMapper adoptMapper;
    @Autowired
    private TbPetsMapper petsMapper;
    @Autowired
    private TbFosterMapper fosterMapper;
    public TaotaoResult addAdopt(BigDecimal petId, BigDecimal userId, String address, String telePhone){
        TbAdopt adopt = new TbAdopt();
        TbPets tbPets = petsMapper.selectByPrimaryKey(petId);
        BigDecimal fosterUserId = tbPets.getOwner();
        Long adoptId = IDUtils.genItemId();
        BigDecimal adopt_Id = new BigDecimal(adoptId);
        adopt.setId(adopt_Id);
        adopt.setFosteruserid(fosterUserId);
        adopt.setAdoptuserid(userId);
        adopt.setAddress(address);
        adopt.setTelephone(telePhone);
        Short status = 1;
        adopt.setStatus(status);
        adopt.setAdoptpetid(petId);
        adopt.setCreated(new Date());
        adopt.setUpdated(new Date());
        adoptMapper.insert(adopt);
        return TaotaoResult.ok();
    }
    @Override
    public Page<myAdopt> getMyAdoptList(Integer pageNumber, BigDecimal userId){
        Page<myAdopt> page = new Page<>(pageNumber);
        TbAdoptExample example = new TbAdoptExample();
        TbAdoptExample.Criteria criteria = example.createCriteria();
        criteria.andAdoptuseridEqualTo(userId);
        Integer count = adoptMapper.countByExample(example);
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNumber, page.getPageSize());
        List<myAdopt> list = new ArrayList<>();
        List<TbAdopt> adoptList = adoptMapper.selectByExample(example);
        for(TbAdopt adopt : adoptList){
            myAdopt adoptView = new myAdopt();
            adoptView.setId(adopt.getId());
            adoptView.setStatus(adopt.getStatus());
            TbPets pet = petsMapper.selectByPrimaryKey(adopt.getAdoptpetid());
            adoptView.setName(pet.getName());
            adoptView.setImage(pet.getImage());
            TbFosterExample example1 = new TbFosterExample();
            TbFosterExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andPetidEqualTo(adopt.getAdoptpetid());
            List<TbFoster> fosters = fosterMapper.selectByExample(example1);
            if(fosters.size() != 0){
                TbFoster foster = fosters.get(0);
                adoptView.setAddress(foster.getAddress());
                adoptView.setTelePhone(foster.getTelephone());
            }
            list.add(adoptView);
        }
        page.setTotalPageItems(count);
        page.setList(list);
        return page;
    }
    @Override
    public TaotaoResult cancelAdopt(BigDecimal id){
        TbAdopt adopt = adoptMapper.selectByPrimaryKey(id);
        Short zero = 0;
        adopt.setStatus(zero);
        adoptMapper.updateByPrimaryKey(adopt);
        return TaotaoResult.ok();
    }
    @Override
    public Page<AdoptMessage> getAdoptMessage(Integer pageNumber,BigDecimal petId){
        Page<AdoptMessage> page = new Page<>(pageNumber);
        TbAdoptExample example = new TbAdoptExample();
        TbAdoptExample.Criteria criteria = example.createCriteria();
        criteria.andAdoptpetidEqualTo(petId);
        Short one = 1;
        criteria.andStatusEqualTo(one);
        Integer count = adoptMapper.countByExample(example);
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNumber, page.getPageSize());
        List<AdoptMessage> list = new ArrayList<>();
        List<TbAdopt> adoptList = adoptMapper.selectByExample(example);
        for(TbAdopt adopt : adoptList){
            AdoptMessage adoptMessage = new AdoptMessage();
            adoptMessage.setAdoptId(adopt.getId());
            adoptMessage.setTelePhone(adopt.getTelephone());
            adoptMessage.setAddress(adopt.getAddress());
            TbPets Pet = petsMapper.selectByPrimaryKey(adopt.getAdoptpetid());
            adoptMessage.setName(Pet.getName());
            list.add(adoptMessage);
        }
        page.setTotalPageItems(count);
        page.setList(list);
        return page;
    }
}
