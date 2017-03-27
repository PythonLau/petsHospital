package com.coco.service;

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
    List<TbPets> getPetList(BigDecimal userId);
}
