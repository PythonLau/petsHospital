package com.coco.service.impl;

import com.coco.mapper.TbDoctorMapper;
import com.coco.pojo.TbDoctor;
import com.coco.pojo.TbDoctorExample;
import com.coco.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private TbDoctorMapper doctorMapper;
    public TbDoctor getDoctor(String username, String password){
        TbDoctorExample example = new TbDoctorExample();
        TbDoctorExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<TbDoctor> list = doctorMapper.selectByExample(example);
        if(list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }
}
