package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.*;
import com.coco.pojo.*;
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
    @Autowired
    private TbPositionCatMapper positionCatMapper;
    @Autowired
    private TbSickRoomMapper sickRoomMapper;
    public TaotaoResult registerMedical(BigDecimal id, Long cid, String name, Date registerDate){
        TbMedical medical = new TbMedical();
        Long medicalId = IDUtils.genItemId();
        BigDecimal medical_Id = new BigDecimal(medicalId);
        medical.setId(medical_Id);
        medical.setPetid(id);
        medical.setOfficeid(cid);
        BigDecimal price = new BigDecimal(0);
        medical.setPrice(price);
        medical.setRegistertime(registerDate);
        medical.setCreated(new Date());
        Short one = 1;
        medical.setStatus(one);
        medicalMapper.insert(medical);
        return TaotaoResult.ok();
    }
//    @Override
//    public Page<CaseHistory> getCaseHistory(Integer pageNumber, BigDecimal petId){
//        Page<CaseHistory> page = new Page<>(pageNumber);
//        TbMedicalExample example = new TbMedicalExample();
//        TbMedicalExample.Criteria criteria = example.createCriteria();
//        criteria.andPetidEqualTo(petId);
//        Integer count = medicalMapper.countByExample(example);
//        System.out.println("count:" + count);
//        example.setOrderByClause("id desc");
//        PageHelper.startPage(pageNumber, page.getPageSize());
//        List<CaseHistory> list = new ArrayList<>();
//        List<TbMedical> medicalList = medicalMapper.selectByExampleWithBLOBs(example);
//        for(TbMedical medical : medicalList){
//            CaseHistory caseHistory = new CaseHistory();
//            caseHistory.setId(medical.getId());
//            caseHistory.setStatus(medical.getStatus());
//            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//            String registerTime = null;
//            if(medical.getUpdated() != null){
//                registerTime = sdf.format(medical.getUpdated());
//            }else{
//                registerTime = sdf.format(medical.getRegistertime());
//            }
//            if(medical.getPrice() != null){
//                caseHistory.setPrice(medical.getPrice());
//            }
//            caseHistory.setMedicalTime(registerTime);
//            caseHistory.setRecipe(medical.getRecipe());
//            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
//            caseHistory.setName(pet.getName());
//            if(medical.getDoctorid() != null){
//                TbEmployee employee = employeeMapper.selectByPrimaryKey(medical.getDoctorid());
//                caseHistory.setDoctorName(employee.getName());
//            }
//            list.add(caseHistory);
//        }
//        page.setTotalPageItems(count);
//        page.setList(list);
//        return page;
//    }
//    @Override
//    public TaotaoResult cancelMedical(BigDecimal caseHistoryId){
//        TbMedical medical = medicalMapper.selectByPrimaryKey(caseHistoryId);
//        Short zero = 0;
//        medical.setStatus(zero);
//        medicalMapper.updateByPrimaryKey(medical);
//        return TaotaoResult.ok();
//    }
//    @Override
//    public BigDecimal getPetId(BigDecimal caseHistoryId){
//        TbMedical medical = medicalMapper.selectByPrimaryKey(caseHistoryId);
//        BigDecimal petId = medical.getPetid();
//        return petId;
//    }
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
            tr.setRegisterTime(medical.getRegistertime());
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
    public TaotaoResult acceptMedical(TbMedical medical){
        TbMedical updateMedical = medicalMapper.selectByPrimaryKey(medical.getId());
        System.out.println("床位:" + medical.getBedroom());
        if(medical.getBedroom() != null){
            updateMedical.setBedroom(medical.getBedroom());
        }
        updateMedical.setSickname(medical.getSickname());
        updateMedical.setDoctorid(medical.getDoctorid());
        updateMedical.setStatus(medical.getStatus());
        updateMedical.setCreated(new Date());
        medicalMapper.updateByPrimaryKey(updateMedical);
        return TaotaoResult.ok();
    }
    @Override
    public EUDataGridResult getMedicalListByDoctor(Integer page,Integer rows,BigDecimal userId){
        TbMedicalExample example = new TbMedicalExample();
        TbMedicalExample.Criteria criteria = example.createCriteria();
        criteria.andDoctoridEqualTo(userId);
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbMedical> list = medicalMapper.selectByExample(example);
        //创建一个返回值对象
        List<treat> treatList = new ArrayList<>();
        EUDataGridResult result = new EUDataGridResult();
        for(TbMedical medical : list){
            treat tr = new treat();
            tr.setId(medical.getId());
            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
            tr.setPetName(pet.getName());
            System.out.println("11111111");
            BigDecimal user_Id = pet.getOwner();
            TbUser user = userMapper.selectByPrimaryKey(user_Id);
            tr.setNickName(user.getNickname());
            tr.setTelePhone(user.getTelphone());
            tr.setSickname(medical.getSickname());
            tr.setPrice(medical.getPrice());
            tr.setWord(medical.getWords());
            tr.setStartMedicalTime(medical.getCreated());
            tr.setEndMedicalTime(medical.getUpdated());
            tr.setStatus(medical.getStatus());
            if(medical.getBedroom() != null){
                TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(medical.getBedroom());
                tr.setBedRoom(sickRoom.getName());
            }
            treatList.add(tr);
        }
        result.setRows(treatList);
        //取记录总条数
        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
//    @Override
//    public TaotaoResult createPrescribe(TbMedical medical,BigDecimal doctorId){
//        String recipe = medical.getRecipe();
//        BigDecimal medicalId = medical.getId();
//        TbMedical tbMedical = medicalMapper.selectByPrimaryKey(medicalId);
//        tbMedical.setRecipe(recipe);
//        tbMedical.setDoctorid(doctorId);
//        Short two = 2;
//        tbMedical.setStatus(two);
//        tbMedical.setUpdated(new Date());
//        medicalMapper.updateByPrimaryKeyWithBLOBs(tbMedical);
//        return TaotaoResult.ok();
//    }
    @Override
    public EUDataGridResult getMedicalOrderList(Integer page, Integer rows){
        TbMedicalExample example = new TbMedicalExample();
        TbMedicalExample.Criteria criteria = example.createCriteria();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbMedical> list = medicalMapper.selectByExample(example);
        //创建一个返回值对象
        List<treat> treatList = new ArrayList<>();
        EUDataGridResult result = new EUDataGridResult();
        for(TbMedical medical : list){
            treat tr = new treat();
            tr.setId(medical.getId());
            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
            tr.setPetName(pet.getName());
            BigDecimal user_Id = pet.getOwner();
            TbUser user = userMapper.selectByPrimaryKey(user_Id);
            tr.setNickName(user.getNickname());
            tr.setTelePhone(user.getTelphone());
            tr.setSickname(medical.getSickname());
            tr.setPrice(medical.getPrice());
            tr.setWord(medical.getWords());
            tr.setStartMedicalTime(medical.getCreated());
            tr.setEndMedicalTime(medical.getUpdated());
            tr.setStatus(medical.getStatus());
            if(medical.getBedroom() != null){
                TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(medical.getBedroom());
                tr.setBedRoom(sickRoom.getName());
            }
            treatList.add(tr);
        }
        result.setRows(treatList);
        //取记录总条数
        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
//    @Override
//    public TaotaoResult updatePrescribeByManager(BigDecimal medicalId,Short status,BigDecimal price){
//        TbMedical medical = medicalMapper.selectByPrimaryKey(medicalId);
//        medical.setStatus(status);
//        medical.setPrice(price);
//        medicalMapper.updateByPrimaryKey(medical);
//        return TaotaoResult.ok();
//    }
//    @Override
//    public EUDataGridResult searchWithKeyOnly(String search_condition,String search_key, Integer page,Integer rows){
//        TbMedicalExample example = new TbMedicalExample();
//        TbMedicalExample.Criteria criteria = example.createCriteria();
//        if(search_condition.equals("id")){
//            BigDecimal id = new BigDecimal(search_key);
//            criteria.andIdEqualTo(id);
//        }else if(search_condition.equals("positionName")){
//            //查询部门id
//            TbPositionCatExample example1 = new TbPositionCatExample();
//            TbPositionCatExample.Criteria criteria1 = example1.createCriteria();
//            criteria1.andNameEqualTo(search_key);
//            List<TbPositionCat> positionCat = positionCatMapper.selectByExample(example1);
//            if(positionCat.size() != 0){
//                BigDecimal positionCatId = positionCat.get(0).getId();
//                criteria.andOfficeidEqualTo(positionCatId.longValue());
//            }else{
//                System.out.println("没有这个部门");
//            }
//        }else if(search_condition.equals("status")){
//            Short status = new Short(search_key);
//            criteria.andStatusEqualTo(status);
//        }
//        PageHelper.startPage(page, rows);
//        List<TbMedical> list = medicalMapper.selectByExampleWithBLOBs(example);
//        //创建一个返回值对象
//        List<CaseHistory> caseList = new ArrayList<>();
//        EUDataGridResult result = new EUDataGridResult();
//        for(TbMedical medical : list){
//            CaseHistory caseHistory = new CaseHistory();
//            caseHistory.setId(medical.getId());
//            if(medical.getUpdated() != null){
//                System.out.println("search with key only");
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                String medicalTime = format.format(medical.getUpdated());
//                caseHistory.setMedicalTime(medicalTime);
//            }
//            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
//            caseHistory.setName(pet.getName());
//            if(medical.getDoctorid() != null){
//                TbEmployee doctor = employeeMapper.selectByPrimaryKey(medical.getDoctorid());
//                caseHistory.setDoctorName(doctor.getName());
//            }
//            caseHistory.setStatus(medical.getStatus());
//            if(medical.getPrice() != null){
//                caseHistory.setPrice(medical.getPrice());
//            }
//            if(medical.getRecipe() != null){
//                caseHistory.setRecipe(medical.getRecipe());
//            }
//            //这是用户id
//            caseList.add(caseHistory);
//        }
//        result.setRows(caseList);
//        //取记录总条数
//        PageInfo<CaseHistory> pageInfo = new PageInfo<>(caseList);
//        result.setTotal(pageInfo.getTotal());
//        return result;
//    }
//    @Override
//    public EUDataGridResult searchWithMedicalTimeOnly(Date beginDate,Date endDate,Integer page,Integer rows){
//        TbMedicalExample example = new TbMedicalExample();
//        TbMedicalExample.Criteria criteria = example.createCriteria();
//        criteria.andUpdatedBetween(beginDate,endDate);
//        PageHelper.startPage(page, rows);
//        List<TbMedical> list = medicalMapper.selectByExampleWithBLOBs(example);
//        //创建一个返回值对象
//        List<CaseHistory> caseList = new ArrayList<>();
//        EUDataGridResult result = new EUDataGridResult();
//        for(TbMedical medical : list){
//            CaseHistory caseHistory = new CaseHistory();
//            caseHistory.setId(medical.getId());
//            if(medical.getUpdated() != null){
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                String medicalTime = format.format(medical.getUpdated());
//                caseHistory.setMedicalTime(medicalTime);
//            }
//            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
//            caseHistory.setName(pet.getName());
//            if(medical.getDoctorid() != null){
//                TbEmployee doctor = employeeMapper.selectByPrimaryKey(medical.getDoctorid());
//                caseHistory.setDoctorName(doctor.getName());
//            }
//            caseHistory.setStatus(medical.getStatus());
//            if(medical.getPrice() != null){
//                caseHistory.setPrice(medical.getPrice());
//            }
//            if(medical.getRecipe() != null){
//                caseHistory.setRecipe(medical.getRecipe());
//            }
//            System.out.println("search with time only");
//            //这是用户id
//            caseList.add(caseHistory);
//        }
//        result.setRows(caseList);
//        //取记录总条数
//        PageInfo<CaseHistory> pageInfo = new PageInfo<>(caseList);
//        result.setTotal(pageInfo.getTotal());
//        return result;
//    }
//    @Override
//    public EUDataGridResult searchWithKeyAndMedicalTime(String search_condition,String search_key,
//                                                        Date beginDate,Date endDate,Integer page,Integer rows){
//        TbMedicalExample example = new TbMedicalExample();
//        TbMedicalExample.Criteria criteria = example.createCriteria();
//        if(search_condition.equals("id")){
//            BigDecimal id = new BigDecimal(search_key);
//            criteria.andIdEqualTo(id);
//        }else if(search_condition.equals("positionName")){
//            //查询部门id
//            TbPositionCatExample example1 = new TbPositionCatExample();
//            TbPositionCatExample.Criteria criteria1 = example1.createCriteria();
//            criteria1.andNameEqualTo(search_key);
//            List<TbPositionCat> positionCat = positionCatMapper.selectByExample(example1);
//            if(positionCat.size() != 0){
//                BigDecimal positionCatId = positionCat.get(0).getId();
//                criteria.andOfficeidEqualTo(positionCatId.longValue());
//            }
//        }else if(search_condition.equals("status")){
//            Short status = new Short(search_key);
//            criteria.andStatusEqualTo(status);
//        }
//        criteria.andUpdatedBetween(beginDate,endDate);
//        PageHelper.startPage(page, rows);
//        List<TbMedical> list = medicalMapper.selectByExampleWithBLOBs(example);
//        //创建一个返回值对象
//        List<CaseHistory> caseList = new ArrayList<>();
//        EUDataGridResult result = new EUDataGridResult();
//        for(TbMedical medical : list){
//            CaseHistory caseHistory = new CaseHistory();
//            caseHistory.setId(medical.getId());
//            if(medical.getUpdated() != null){
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                String medicalTime = format.format(medical.getUpdated());
//                caseHistory.setMedicalTime(medicalTime);
//            }
//            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
//            caseHistory.setName(pet.getName());
//            if(medical.getDoctorid() != null){
//                TbEmployee doctor = employeeMapper.selectByPrimaryKey(medical.getDoctorid());
//                caseHistory.setDoctorName(doctor.getName());
//            }
//            caseHistory.setStatus(medical.getStatus());
//            if(medical.getPrice() != null){
//                caseHistory.setPrice(medical.getPrice());
//            }
//            if(medical.getRecipe() != null){
//                caseHistory.setRecipe(medical.getRecipe());
//            }
//            //这是用户id
//            System.out.println("search with key and time");
//            caseList.add(caseHistory);
//        }
//        result.setRows(caseList);
//        //取记录总条数
//        PageInfo<CaseHistory> pageInfo = new PageInfo<>(caseList);
//        result.setTotal(pageInfo.getTotal());
//        return result;
//    }
//    @Override
//    public EUDataGridResult searchWithKeyOnlyByDoctor(String search_condition,String search_key, Integer page,Integer rows){
//        TbMedicalExample example = new TbMedicalExample();
//        TbMedicalExample.Criteria criteria = example.createCriteria();
//        if(search_condition.equals("id")){
//            BigDecimal id = new BigDecimal(search_key);
//            criteria.andIdEqualTo(id);
//        }
//        PageHelper.startPage(page, rows);
//        List<TbMedical> list = medicalMapper.selectByExample(example);
//        //创建一个返回值对象
//        List<treat> treatList = new ArrayList<>();
//        EUDataGridResult result = new EUDataGridResult();
//        for(TbMedical medical : list){
//            treat tr = new treat();
//            tr.setId(medical.getId());
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            String registerTime = format.format(medical.getRegistertime());
//            tr.setRegisterTime(registerTime);
//            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
//            tr.setPetName(pet.getName());
//            //这是用户id
//            System.out.println("1111111111");
//            BigDecimal user_Id = pet.getOwner();
//            TbUser user = userMapper.selectByPrimaryKey(user_Id);
//            tr.setNickName(user.getNickname());
//            tr.setTelePhone(user.getTelphone());
//            treatList.add(tr);
//            System.out.println("预约时间:" + tr.getRegisterTime());
//        }
//        result.setRows(treatList);
//        //取记录总条数
//        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
//        result.setTotal(pageInfo.getTotal());
//        return result;
//    }
//    @Override
//    public EUDataGridResult searchWithMedicalTimeOnlyByDoctor(Date beginDate,Date endDate,Integer page,Integer rows){
//        TbMedicalExample example = new TbMedicalExample();
//        TbMedicalExample.Criteria criteria = example.createCriteria();
//        criteria.andRegistertimeBetween(beginDate,endDate);
//        PageHelper.startPage(page, rows);
//        List<TbMedical> list = medicalMapper.selectByExample(example);
//        //创建一个返回值对象
//        List<treat> treatList = new ArrayList<>();
//        EUDataGridResult result = new EUDataGridResult();
//        for(TbMedical medical : list){
//            treat tr = new treat();
//            tr.setId(medical.getId());
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            String registerTime = format.format(medical.getRegistertime());
//            tr.setRegisterTime(registerTime);
//            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
//            tr.setPetName(pet.getName());
//            //这是用户id
//            System.out.println("11111111");
//            BigDecimal user_Id = pet.getOwner();
//            TbUser user = userMapper.selectByPrimaryKey(user_Id);
//            tr.setNickName(user.getNickname());
//            tr.setTelePhone(user.getTelphone());
//            treatList.add(tr);
//            System.out.println("预约时间:" + tr.getRegisterTime());
//        }
//        result.setRows(treatList);
//        //取记录总条数
//        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
//        result.setTotal(pageInfo.getTotal());
//        return result;
//    }
//    @Override
//    public EUDataGridResult searchWithKeyAndMedicalTimeByDoctor(String search_condition,String search_key,
//                                                                Date beginDate,Date endDate,Integer page,Integer rows){
//        TbMedicalExample example = new TbMedicalExample();
//        TbMedicalExample.Criteria criteria = example.createCriteria();
//        if(search_condition.equals("id")){
//            BigDecimal id = new BigDecimal(search_key);
//            criteria.andIdEqualTo(id);
//        }
//        criteria.andRegistertimeBetween(beginDate,endDate);
//        PageHelper.startPage(page, rows);
//        List<TbMedical> list = medicalMapper.selectByExample(example);
//        //创建一个返回值对象
//        List<treat> treatList = new ArrayList<>();
//        EUDataGridResult result = new EUDataGridResult();
//        for(TbMedical medical : list){
//            treat tr = new treat();
//            tr.setId(medical.getId());
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            String registerTime = format.format(medical.getRegistertime());
//            tr.setRegisterTime(registerTime);
//            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
//            tr.setPetName(pet.getName());
//            //这是用户id
//            System.out.println("2222222222");
//            BigDecimal user_Id = pet.getOwner();
//            TbUser user = userMapper.selectByPrimaryKey(user_Id);
//            tr.setNickName(user.getNickname());
//            tr.setTelePhone(user.getTelphone());
//            treatList.add(tr);
//            System.out.println("预约时间:" + tr.getRegisterTime());
//        }
//        result.setRows(treatList);
//        //取记录总条数
//        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
//        result.setTotal(pageInfo.getTotal());
//        return result;
//    }
}
