package com.coco.service.impl;

import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbPetsMapper;
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
    public List<TbPets> getPetList(BigDecimal userId){
        TbPetsExample example = new TbPetsExample();
        TbPetsExample.Criteria criteria = example.createCriteria();
        criteria.andOwnerEqualTo(userId);
        List<TbPets> list = petsMapper.selectByExample(example);
        return list;
    }
}