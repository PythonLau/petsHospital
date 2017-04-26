package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.mapper.TbDoctorMapper;
import com.coco.pojo.TbDoctor;
import com.coco.pojo.TbDoctorExample;
import com.coco.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @Override
    public EUDataGridResult getDoctorAccountList(Integer page, Integer rows){
        TbDoctorExample example = new TbDoctorExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbDoctor> list = doctorMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbDoctor> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
