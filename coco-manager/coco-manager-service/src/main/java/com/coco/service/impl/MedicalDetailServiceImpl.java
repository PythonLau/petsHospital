package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbMedicalDetailMapper;
import com.coco.mapper.TbMedicalMapper;
import com.coco.mapper.TbOperatingRoomMapper;
import com.coco.pojo.*;
import com.coco.service.MedicalDetailService;
import com.coco.service.MedicalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
@Service
public class MedicalDetailServiceImpl implements MedicalDetailService{
    @Autowired
    private TbMedicalDetailMapper medicalDetailMapper;
    @Autowired
    private TbMedicalMapper medicalMapper;
    @Autowired
    private TbOperatingRoomMapper operatingRoomMapper;
    @Override
    public TaotaoResult saveMedicalDetail(TbMedicalDetail medicalDetail){
        medicalDetail.setMedicalid(medicalDetail.getId());
        Long medicalDetailId = IDUtils.genItemId();
        BigDecimal medical_Detail_Id = new BigDecimal(medicalDetailId);
        medicalDetail.setId(medical_Detail_Id);
        System.out.println("11111111");
        medicalDetail.setCreated(new Date());
        medicalDetail.setUpdated(new Date());
        medicalDetailMapper.insert(medicalDetail);
        return TaotaoResult.ok();
    }
    @Override
    public EUDataGridResult getMedicalDetailByDoctor(BigDecimal medicalId,Integer page,Integer rows){
        TbMedicalDetailExample example = new TbMedicalDetailExample();
        TbMedicalDetailExample.Criteria criteria = example.createCriteria();
        criteria.andMedicalidEqualTo(medicalId);
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbMedicalDetail> list = medicalDetailMapper.selectByExampleWithBLOBs(example);
        //创建一个返回值对象
        List<MedicalDetailView> medicalDetailList = new ArrayList<>();
        EUDataGridResult result = new EUDataGridResult();
        for(TbMedicalDetail medicalDetail : list){
            MedicalDetailView medicalDetailView = new MedicalDetailView();
            medicalDetailView.setId(medicalDetail.getId());
            medicalDetailView.setMedicalid(medicalDetail.getMedicalid());
            medicalDetailView.setSickname(medicalDetail.getSickname());
            medicalDetailView.setRecipe(medicalDetail.getRecipe());
            medicalDetailView.setPrice(medicalDetail.getPrice());
            medicalDetailView.setNeeddays(medicalDetail.getNeeddays());
            medicalDetailView.setCreated(medicalDetail.getCreated());
            medicalDetailView.setUpdated(medicalDetail.getUpdated());
            medicalDetailView.setStatus(medicalDetail.getStatus());
            if(medicalDetail.getStatus() == 2){
                TbOperatingRoom operatingRoom = operatingRoomMapper.selectByPrimaryKey(medicalDetail.getRoom());
                medicalDetailView.setRoom(operatingRoom.getName());
            }
            medicalDetailList.add(medicalDetailView);
        }
        result.setRows(medicalDetailList);
        //取记录总条数
        PageInfo<MedicalDetailView> pageInfo = new PageInfo<>(medicalDetailList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public EUDataGridResult getMedicalDetailByManager(BigDecimal medicalId,Integer page,Integer rows){
        TbMedicalDetailExample example = new TbMedicalDetailExample();
        TbMedicalDetailExample.Criteria criteria = example.createCriteria();
        criteria.andMedicalidEqualTo(medicalId);
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbMedicalDetail> list = medicalDetailMapper.selectByExampleWithBLOBs(example);
        //创建一个返回值对象
        List<MedicalDetailView> medicalDetailList = new ArrayList<>();
        EUDataGridResult result = new EUDataGridResult();
        for(TbMedicalDetail medicalDetail : list){
            MedicalDetailView medicalDetailView = new MedicalDetailView();
            medicalDetailView.setId(medicalDetail.getId());
            medicalDetailView.setMedicalid(medicalDetail.getMedicalid());
            medicalDetailView.setSickname(medicalDetail.getSickname());
            medicalDetailView.setRecipe(medicalDetail.getRecipe());
            medicalDetailView.setPrice(medicalDetail.getPrice());
            medicalDetailView.setCreated(medicalDetail.getCreated());
            medicalDetailView.setUpdated(medicalDetail.getUpdated());
            medicalDetailView.setNeeddays(medicalDetail.getNeeddays());
            medicalDetailView.setStatus(medicalDetail.getStatus());
            if(medicalDetail.getStatus() == 2){
                TbOperatingRoom operatingRoom = operatingRoomMapper.selectByPrimaryKey(medicalDetail.getRoom());
                medicalDetailView.setRoom(operatingRoom.getName());
            }
            medicalDetailList.add(medicalDetailView);
        }
        result.setRows(medicalDetailList);
        //取记录总条数
        PageInfo<MedicalDetailView> pageInfo = new PageInfo<>(medicalDetailList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public TaotaoResult updateMedicalDetailByManager(TbMedicalDetail medicalDetail){
        Short four = 4;
        BigDecimal price = new BigDecimal(0);
        TbMedicalDetail updateMedicalDetail = medicalDetailMapper.selectByPrimaryKey(medicalDetail.getId());
        updateMedicalDetail.setPrice(medicalDetail.getPrice());
        updateMedicalDetail.setStatus(medicalDetail.getStatus());
        medicalDetailMapper.updateByPrimaryKey(updateMedicalDetail);
        TbMedical medical = medicalMapper.selectByPrimaryKey(medicalDetail.getMedicalid());
        TbMedicalDetailExample example = new TbMedicalDetailExample();
        TbMedicalDetailExample.Criteria criteria = example.createCriteria();
        criteria.andMedicalidEqualTo(medicalDetail.getMedicalid());
        criteria.andStatusEqualTo(four);
        List<TbMedicalDetail> medicalDetailList = medicalDetailMapper.selectByExample(example);
        for(TbMedicalDetail medicalDetail1 : medicalDetailList){
            System.out.println("price begin:" + price);
            price = price.add(medicalDetail1.getPrice());
            System.out.println("price end:" + price);
        }
        System.out.println("price end end:" + price);
        medical.setPrice(price);
        medicalMapper.updateByPrimaryKey(medical);
        return TaotaoResult.ok();
    }
}
