package com.coco.service.impl;

import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbFosterMapper;
import com.coco.mapper.TbPetsMapper;
import com.coco.pojo.TbFoster;
import com.coco.pojo.TbFosterExample;
import com.coco.pojo.TbPets;
import com.coco.pojo.TbPetsExample;
import com.coco.service.FosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
@Service
public class FosterServiceImpl implements FosterService {
    @Autowired
    private TbFosterMapper fosterMapper;
    @Autowired
    private TbPetsMapper petsMapper;
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
}
