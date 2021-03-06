package com.coco.service.impl;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbAdoptMapper;
import com.coco.mapper.TbFosterMapper;
import com.coco.mapper.TbMedicalMapper;
import com.coco.mapper.TbPetsMapper;
import com.coco.pojo.*;
import com.coco.service.PetService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27 0027.
 */
@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private TbPetsMapper petsMapper;
    @Autowired
    private TbFosterMapper fosterMapper;
    @Autowired
    private TbAdoptMapper adoptMapper;
    @Autowired
    private TbMedicalMapper medicalMapper;
    @Override
    public TaotaoResult addPet(BigDecimal owner, String petName, String typeName,
                               Short petAge, String petSex, String image){
        try{
            TbPets tbPet = new TbPets();
            Long petId = IDUtils.genItemId();
            BigDecimal pet_Id = new BigDecimal(petId);
            tbPet.setId(pet_Id);
            tbPet.setName(petName);
            tbPet.setTypename(typeName);
            tbPet.setOwner(owner);
            tbPet.setAge(petAge);
            tbPet.setSex(petSex);
            Short status = 1;
            tbPet.setStatus(status);
            tbPet.setImage(image);
            tbPet.setCreated(new Date());
            tbPet.setUpdated(new Date());
            petsMapper.insert(tbPet);
            return TaotaoResult.build(200,"新增宠物成功");
        }catch (Exception e){
            String s = e.getCause().toString();
            return TaotaoResult.build(500,s);
        }
    }
    @Override
    public Page<TbPets> getPetList(Integer pageNumber,BigDecimal userId){
        Page<TbPets> page = new Page<>(pageNumber);
        TbPetsExample example = new TbPetsExample();
        TbPetsExample.Criteria criteria = example.createCriteria();
        Short zero = 0;
        criteria.andStatusNotEqualTo(zero);
        criteria.andOwnerEqualTo(userId);
        Integer count = petsMapper.countByExample(example);
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNumber, page.getPageSize());
        List<TbPets> list = petsMapper.selectByExample(example);
        page.setTotalPageItems(count);
        page.setList(list);
        return page;
    }
    @Override
    public TaotaoResult deletePet(BigDecimal petId){
        Short zero = 0;
        Short one = 1;
        Short two = 2;
        Short three = 3;
        TbFosterExample example = new TbFosterExample();
        TbFosterExample.Criteria criteria = example.createCriteria();
        TbAdoptExample example1 = new TbAdoptExample();
        TbAdoptExample.Criteria criteria1 = example1.createCriteria();
        TbMedicalExample example2 = new TbMedicalExample();
        TbMedicalExample.Criteria criteria2 = example2.createCriteria();
        TbPetsExample example3 = new TbPetsExample();
        TbPetsExample.Criteria criteria3 = example3.createCriteria();
        criteria.andPetidEqualTo(petId);
        criteria.andStatusEqualTo(one);
        List<TbFoster> fosterList = fosterMapper.selectByExample(example);
        for(TbFoster foster : fosterList){
            foster.setStatus(zero);
            fosterMapper.updateByPrimaryKey(foster);
        }
        criteria1.andAdoptpetidEqualTo(petId);
        criteria1.andStatusEqualTo(one);
        List<TbAdopt> adoptList = adoptMapper.selectByExample(example1);
        for(TbAdopt adopt : adoptList){
            adopt.setStatus(zero);
            adoptMapper.updateByPrimaryKey(adopt);
        }
        criteria2.andPetidEqualTo(petId);
        criteria2.andStatusNotEqualTo(three);
        List<TbMedical> medicalList = medicalMapper.selectByExample(example2);
        for(TbMedical medical : medicalList){
            medical.setStatus(zero);
            medicalMapper.updateByPrimaryKey(medical);
        }
        criteria3.andIdEqualTo(petId);
        List<TbPets> petsList = petsMapper.selectByExample(example3);
        for(TbPets pet : petsList){
            pet.setStatus(zero);
            petsMapper.updateByPrimaryKey(pet);
        }
        return TaotaoResult.ok();
    }
    @Override
    public TbPets getPet(BigDecimal petId){
        TbPetsExample example = new TbPetsExample();
        TbPetsExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(petId);
        List<TbPets> tbPets = petsMapper.selectByExample(example);
        if(tbPets.size() != 0){
            return tbPets.get(0);
        }else{
            return null;
        }
    }
    @Override
    public TaotaoResult editPet(BigDecimal petId, String petName, String typeName,
                                BigDecimal owner, Short petAge, String petSex, String image){
        TbPets tbPet = new TbPets();
        tbPet.setId(petId);
        tbPet.setName(petName);
        tbPet.setTypename(typeName);
        tbPet.setOwner(owner);
        tbPet.setAge(petAge);
        tbPet.setSex(petSex);
        Short status = 1;
        tbPet.setStatus(status);
        tbPet.setImage(image);
        tbPet.setUpdated(new Date());
        petsMapper.updateByPrimaryKey(tbPet);
        return TaotaoResult.ok();
    }
    @Override
    public boolean judgePetBelongToUser(BigDecimal userId,BigDecimal petId){
        TbPetsExample example = new TbPetsExample();
        TbPetsExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(petId);
        criteria.andOwnerEqualTo(userId);
        List<TbPets> tbPets = petsMapper.selectByExample(example);
        if(tbPets.size() == 0){
            return false;
        }else{
            return true;
        }
    }
}