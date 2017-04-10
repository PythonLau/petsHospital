package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbEmployeeMapper;
import com.coco.mapper.TbMedicalMapper;
import com.coco.mapper.TbPetsMapper;
import com.coco.mapper.TbUserMapper;
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
    @Autowired
    private TbUserMapper userMapper;
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
        List<TbMedical> medicalList = medicalMapper.selectByExampleWithBLOBs(example);
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
        List<treat> treatList = new ArrayList<>();
        EUDataGridResult result = new EUDataGridResult();
        for(TbMedical medical : list){
            treat tr = new treat();
            tr.setId(medical.getId());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String registerTime = format.format(medical.getRegistertime());
            tr.setRegisterTime(registerTime);
            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
            tr.setPetName(pet.getName());
            //这是用户id
            BigDecimal user_Id = pet.getOwner();
            TbUser user = userMapper.selectByPrimaryKey(user_Id);
            tr.setNickName(user.getNickname());
            tr.setTelePhone(user.getTelphone());
            treatList.add(tr);
            System.out.println("预约时间:" + tr.getRegisterTime());
        }
        result.setRows(treatList);
        //取记录总条数
        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
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
        medicalMapper.updateByPrimaryKeyWithBLOBs(tbMedical);
        return TaotaoResult.ok();
    }
    @Override
    public EUDataGridResult getMedicalOrderList(Integer page, Integer rows){
        TbMedicalExample example = new TbMedicalExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbMedical> list = medicalMapper.selectByExampleWithBLOBs(example);
        //创建一个返回值对象
        List<CaseHistory> caseList = new ArrayList<>();
        EUDataGridResult result = new EUDataGridResult();
        for(TbMedical medical : list){
            CaseHistory caseHistory = new CaseHistory();
            caseHistory.setId(medical.getId());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String registerTime = format.format(medical.getUpdated());
            caseHistory.setMedicalTime(registerTime);
            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
            caseHistory.setName(pet.getName());
            TbEmployee doctor = employeeMapper.selectByPrimaryKey(medical.getDoctorid());
            caseHistory.setDoctorName(doctor.getName());
            caseHistory.setStatus(medical.getStatus());
            caseHistory.setPrice(medical.getPrice());
            caseHistory.setRecipe(medical.getRecipe());
            //这是用户id
            caseList.add(caseHistory);
        }
        result.setRows(caseList);
        //取记录总条数
        PageInfo<CaseHistory> pageInfo = new PageInfo<>(caseList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public TaotaoResult updatePrescribeByManager(BigDecimal medicalId,Short status,BigDecimal price){
        TbMedical medical = medicalMapper.selectByPrimaryKey(medicalId);
        medical.setStatus(status);
        medical.setPrice(price);
        medicalMapper.updateByPrimaryKey(medical);
        return TaotaoResult.ok();
    }
}
