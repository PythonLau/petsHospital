package com.coco.service;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbPets;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27 0027.
 */
public interface PetService {
    TaotaoResult addPet(BigDecimal owner, String petName, String typeName,
                        Short petAge, String petSex, String image);
    Page<TbPets> getPetList(Integer pageNumber, BigDecimal userId);
    TaotaoResult deletePet(BigDecimal petId);
    TbPets getPet(BigDecimal petId);
    TaotaoResult editPet(BigDecimal petId,String petName, String typeName, BigDecimal owner, Short petAge, String petSex, String image);
    boolean judgePetBelongToUser(BigDecimal userId,BigDecimal petId);
}
