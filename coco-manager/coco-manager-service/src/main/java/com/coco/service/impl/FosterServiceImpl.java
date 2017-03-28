package com.coco.service.impl;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
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
    @Override
    public TaotaoResult addFoster(String id, String address, String telePhone){
        TbFoster foster = new TbFoster();
        Long fosterId = IDUtils.genItemId();
        BigDecimal foster_Id = new BigDecimal(fosterId);
        foster.setId(foster_Id);
        BigDecimal petId = new BigDecimal(id);
        foster.setPetid(petId);
        Short status = 1;
        foster.setStatus(status);
        foster.setAddress(address);
        foster.setTelephone(telePhone);
        foster.setCreated(new Date());
        foster.setUpdated(new Date());
        TbFosterExample example = new TbFosterExample();
        TbFosterExample.Criteria criteria = example.createCriteria();
        fosterMapper.insert(foster);
        TbPetsExample example1 = new TbPetsExample();
        TbPetsExample.Criteria criteria1 = example1.createCriteria();
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
        criteria1.andPetidEqualTo(id);
        criteria.andIdEqualTo(id);
        List<TbPets> tbPetsList = petsMapper.selectByExample(example);
        List<TbFoster> tbFostersList = fosterMapper.selectByExample(example1);
        if(tbPetsList.size() != 0 && tbFostersList.size() != 0){
            TbPets tbPets = tbPetsList.get(0);
            Short status = 1;
            tbPets.setStatus(status);
            petsMapper.updateByPrimaryKey(tbPets);
            TbFoster foster = tbFostersList.get(0);
            Short fosterStatus = 0;
            foster.setStatus(fosterStatus);
            fosterMapper.updateByPrimaryKey(foster);
            return TaotaoResult.build(200,"取消寄养成功");
        }
        return TaotaoResult.build(500,"取消寄养失败");
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
