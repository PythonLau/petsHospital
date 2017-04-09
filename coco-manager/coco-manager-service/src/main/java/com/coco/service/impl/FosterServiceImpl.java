package com.coco.service.impl;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbAdoptMapper;
import com.coco.mapper.TbFosterMapper;
import com.coco.mapper.TbPetsMapper;
import com.coco.pojo.*;
import com.coco.service.FosterService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
@Service
public class FosterServiceImpl implements FosterService {
    @Autowired
    private TbFosterMapper fosterMapper;
    @Autowired
    private TbPetsMapper petsMapper;
    @Autowired
    private TbAdoptMapper adoptMapper;
    @Override
    public TaotaoResult addFoster(String id, String contacts, String address, String telePhone){
        TbFoster foster = new TbFoster();
        Long fosterId = IDUtils.genItemId();
        BigDecimal foster_Id = new BigDecimal(fosterId);
        foster.setId(foster_Id);
        BigDecimal petId = new BigDecimal(id);
        foster.setPetid(petId);
        Short status = 1;
        foster.setStatus(status);
        foster.setContacts(contacts);
        foster.setAddress(address);
        foster.setTelephone(telePhone);
        foster.setCreated(new Date());
        foster.setUpdated(new Date());
        System.out.println("插入的状态:" + foster.getStatus());
        fosterMapper.insert(foster);
        TbPets tbPets = petsMapper.selectByPrimaryKey(petId);
        Short petStatus = 2;
        tbPets.setStatus(petStatus);
        petsMapper.updateByPrimaryKey(tbPets);
        return TaotaoResult.ok();
    }
    @Override
    public TaotaoResult upFoster(BigDecimal id){
        TbPetsExample example = new TbPetsExample();
        TbPetsExample.Criteria criteria = example.createCriteria();
        TbFosterExample example1 = new TbFosterExample();
        TbFosterExample.Criteria criteria1 = example1.createCriteria();
        TbAdoptExample example2 = new TbAdoptExample();
        TbAdoptExample.Criteria criteria2 = example2.createCriteria();
        Short zero = 0;
        Short one = 1;
        Short two = 2;
        criteria1.andStatusEqualTo(one);
        criteria1.andPetidEqualTo(id);
        criteria.andStatusEqualTo(two);
        criteria.andIdEqualTo(id);
        criteria2.andStatusEqualTo(one);
        criteria2.andAdoptpetidEqualTo(id);
        List<TbPets> tbPetsList = petsMapper.selectByExample(example);
        List<TbFoster> tbFostersList = fosterMapper.selectByExample(example1);
        List<TbAdopt> tbAdoptList = adoptMapper.selectByExample(example2);
        for(TbPets pet : tbPetsList){
            pet.setStatus(one);
            petsMapper.updateByPrimaryKey(pet);
        }
        for(TbFoster foster : tbFostersList){
            foster.setStatus(zero);
            fosterMapper.updateByPrimaryKey(foster);
        }
        for(TbAdopt adopt : tbAdoptList){
            adopt.setStatus(zero);
            adoptMapper.updateByPrimaryKey(adopt);
        }
        return TaotaoResult.build(200,"取消寄养成功");
    }
    @Override
    public Page<adoptPet> getAdoptList(Integer pageNumber){
        Page<adoptPet> page = new Page<>(pageNumber);
        TbFosterExample example = new TbFosterExample();
        TbFosterExample.Criteria criteria = example.createCriteria();
        Short status = 1;
        criteria.andStatusEqualTo(status);
        Integer count = fosterMapper.countByExample(example);
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNumber, page.getPageSize());
        List<adoptPet> list = new ArrayList<>();
        List<TbFoster> fosterList = fosterMapper.selectByExample(example);
        for(TbFoster foster : fosterList){
            adoptPet Pet = new adoptPet();
            Pet.setFosterId(foster.getId());
            Pet.setPetId(foster.getPetid());
            Pet.setContacts(foster.getContacts());
            Pet.setAddress(foster.getAddress());
            Pet.setTelePhone(foster.getTelephone());
            TbPets tbPet = petsMapper.selectByPrimaryKey(foster.getPetid());
            Pet.setName(tbPet.getName());
            Pet.setImage(tbPet.getImage());
            list.add(Pet);
        }
        page.setTotalPageItems(count);
        page.setList(list);
        return page;
    }
}
