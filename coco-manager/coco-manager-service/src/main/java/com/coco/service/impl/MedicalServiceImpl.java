package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbEmployeeMapper;
import com.coco.mapper.TbMedicalMapper;
import com.coco.mapper.TbPetsMapper;
import com.coco.pojo.*;
import com.coco.service.MedicalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
@Service
public class MedicalServiceImpl implements MedicalService {
    @Autowired
    private TbMedicalMapper medicalMapper;
    @Autowired
    private TbPetsMapper petsMapper;
    @Autowired
    private TbEmployeeMapper employeeMapper;
    public TaotaoResult registerMedical(BigDecimal id, Long cid, String name, Date registerDate){
        TbMedical medical = new TbMedical();
        Long medicalId = IDUtils.genItemId();
        BigDecimal medical_Id = new BigDecimal(medicalId);
        medical.setId(medical_Id);
        medical.setPetid(id);
        medical.setOfficeid(cid);
        medical.setRegistertime(registerDate);
        medical.setCreated(new Date());
        Short one = 1;
        medical.setStatus(one);
        medicalMapper.insert(medical);
        return TaotaoResult.ok();
    }
    @Override
    public Page<CaseHistory> getCaseHistory(Integer pageNumber, BigDecimal petId){
        Page<CaseHistory> page = new Page<>(pageNumber);
        TbMedicalExample example = new TbMedicalExample();
        TbMedicalExample.Criteria criteria = example.createCriteria();
        criteria.andPetidEqualTo(petId);
        Integer count = medicalMapper.countByExample(example);
        System.out.println("count:" + count);
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNumber, page.getPageSize());
        List<CaseHistory> list = new ArrayList<>();
        List<TbMedical> medicalList = medicalMapper.selectByExample(example);
        for(TbMedical medical : medicalList){
            CaseHistory caseHistory = new CaseHistory();
            caseHistory.setId(medical.getId());
            caseHistory.setStatus(medical.getStatus());
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String registerTime = null;
            if(medical.getUpdated() != null){
                registerTime = sdf.format(medical.getUpdated());
            }else{
                registerTime = sdf.format(medical.getRegistertime());
            }
            if(medical.getPrice() != null){
                caseHistory.setPrice(medical.getPrice());
            }
            caseHistory.setMedicalTime(registerTime);
            caseHistory.setRecipe(medical.getRecipe());
            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
            caseHistory.setName(pet.getName());
            if(medical.getDoctorid() != null){
                TbEmployee employee = employeeMapper.selectByPrimaryKey(medical.getDoctorid());
                caseHistory.setDoctorName(employee.getName());
            }
            list.add(caseHistory);
        }
        page.setTotalPageItems(count);
        page.setList(list);
        return page;
    }
    @Override
    public TaotaoResult cancelMedical(BigDecimal caseHistoryId){
        TbMedical medical = medicalMapper.selectByPrimaryKey(caseHistoryId);
        Short zero = 0;
        medical.setStatus(zero);
        medicalMapper.updateByPrimaryKey(medical);
        return TaotaoResult.ok();
    }
    @Override
    public BigDecimal getPetId(BigDecimal caseHistoryId){
        TbMedical medical = medicalMapper.selectByPrimaryKey(caseHistoryId);
        BigDecimal petId = medical.getPetid();
        return petId;
    }
    @Override
    public EUDataGridResult getTreatList(int page, int rows,BigDecimal userId){
        TbMedicalExample example = new TbMedicalExample();
        TbMedicalExample.Criteria criteria = example.createCriteria();
        TbEmployee employee = employeeMapper.selectByPrimaryKey(userId);
        Long positionCatId = employee.getCid();
        criteria.andOfficeidEqualTo(positionCatId);
        Short one = 1;
        criteria.andStatusEqualTo(one);
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbMedical> list = medicalMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbMedical> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public TaotaoResult createPrescribe(TbMedical medical,BigDecimal doctorId){
        String recipe = medical.getRecipe();
        BigDecimal medicalId = medical.getId();
        TbMedical tbMedical = medicalMapper.selectByPrimaryKey(medicalId);
        tbMedical.setRecipe(recipe);
        tbMedical.setDoctorid(doctorId);
        Short two = 2;
        tbMedical.setStatus(two);
        tbMedical.setUpdated(new Date());
        medicalMapper.updateByPrimaryKey(tbMedical);
        return TaotaoResult.ok();
    }
}
