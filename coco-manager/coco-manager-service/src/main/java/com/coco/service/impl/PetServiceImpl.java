package com.coco.service.impl;

import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbFosterMapper;
import com.coco.mapper.TbPetsMapper;
import com.coco.pojo.TbFoster;
import com.coco.pojo.TbFosterExample;
import com.coco.pojo.TbPets;
import com.coco.pojo.TbPetsExample;
import com.coco.service.PetService;
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
    public List<TbPets> getPetList(BigDecimal userId){
        TbPetsExample example = new TbPetsExample();
        TbPetsExample.Criteria criteria = example.createCriteria();
        criteria.andOwnerEqualTo(userId);
        List<TbPets> list = petsMapper.selectByExample(example);
        return list;
    }
    @Override
    public TaotaoResult deletePet(BigDecimal petId){
        TbPetsExample example = new TbPetsExample();
        TbPetsExample.Criteria criteria = example.createCriteria();
        TbFosterExample example1 = new TbFosterExample();
        TbFosterExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andPetidEqualTo(petId);
        Short statusTrue = 1;
        criteria1.andStatusEqualTo(statusTrue);
        criteria.andIdEqualTo(petId);
        petsMapper.deleteByExample(example);
        List<TbFoster> fosters = fosterMapper.selectByExample(example1);
        if(fosters.size() != 0){
            TbFoster foster = fosters.get(0);
            Short status = 0;
            foster.setStatus(status);
            fosterMapper.updateByPrimaryKey(foster);
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
}