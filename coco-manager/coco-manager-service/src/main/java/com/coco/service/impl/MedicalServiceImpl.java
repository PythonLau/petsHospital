package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.pojo.searchParamsWithTime;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.*;
import com.coco.pojo.*;
import com.coco.service.MedicalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private TbMedicalDetailMapper medicalDetailMapper;
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
        medical.setUpdated(new Date());
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
            TbPets pet = petsMapper.selectByPrimaryKey(medical.getPetid());
            caseHistory.setPetName(pet.getName());
            caseHistory.setSickName(medical.getSickname());
            if(medical.getOfficeid() != null){
                BigDecimal officeId = new BigDecimal(medical.getOfficeid());
                TbPositionCat positionCat = positionCatMapper.selectByPrimaryKey(officeId);
                caseHistory.setOffice(positionCat.getName());
            }
            caseHistory.setStatus(medical.getStatus());
            if(medical.getDoctorid() != null){
                TbEmployee employee = employeeMapper.selectByPrimaryKey(medical.getDoctorid());
                caseHistory.setDoctorName(employee.getName());
            }
            if(medical.getBedroom() != null){
                TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(medical.getBedroom());
                caseHistory.setBedRoom(sickRoom.getName());
            }
            caseHistory.setPrice(medical.getPrice());
            caseHistory.setWords(medical.getWords());
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String startDate = null;
            String endDate = null;
            if(medical.getCreated() != null){
                startDate = sdf.format(medical.getCreated());
                caseHistory.setStartDate(startDate);
            }else{
                startDate = sdf.format(medical.getRegistertime());
                caseHistory.setStartDate(startDate);
            }
            caseHistory.setStartDate(startDate);
            if(medical.getUpdated() != null){
                endDate = sdf.format(medical.getCreated());
                caseHistory.setEndDate(endDate);
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
    public EUDataGridResult searchTreatByDoctor(searchParamsWithTime search_params,BigDecimal doctorId){
        String search_condition = search_params.getSearch_condition();
        String search_key = search_params.getSearch_key();
        Date beginDate = search_params.getBeginDate();
        Date endDate = search_params.getEndDate();
        Integer page = Integer.valueOf(search_params.getPageNumber());
        Integer rows = Integer.valueOf(search_params.getRows());
        TbMedicalExample example = new TbMedicalExample();
        TbMedicalExample.Criteria criteria = example.createCriteria();
        TbEmployee employee = employeeMapper.selectByPrimaryKey(doctorId);
        Long positionCatId = employee.getCid();
        criteria.andOfficeidEqualTo(positionCatId);
        Short one = 1;
        criteria.andStatusEqualTo(one);
        if(search_key.length() != 0){
            if(search_condition.equals("id")){
                BigDecimal id = new BigDecimal(search_key);
                System.out.println("1111111111");
                criteria.andIdEqualTo(id);
            }
        }
        if((beginDate != null && endDate != null)){
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(beginDate);
            calendar.add(Calendar.HOUR,-8);
            beginDate = calendar.getTime();
            System.out.println("2222222222");
            calendar.setTime(endDate);
            calendar.add(Calendar.HOUR,-8);
            endDate = calendar.getTime();
            criteria.andRegistertimeBetween(beginDate,endDate);
        }
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
            tr.setTelePhone(user.getTelphone());
            tr.setNickName(user.getNickname());
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
        Short zero = 0;
        TbMedical updateMedical = medicalMapper.selectByPrimaryKey(medical.getId());
        System.out.println("床位:" + medical.getBedroom());
        if(medical.getBedroom() != null){
            updateMedical.setBedroom(medical.getBedroom());
            TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(medical.getBedroom());
            sickRoom.setStatus(zero);
            sickRoomMapper.updateByPrimaryKey(sickRoom);
        }
        updateMedical.setSickname(medical.getSickname());
        updateMedical.setDoctorid(medical.getDoctorid());
        updateMedical.setStatus(medical.getStatus());
        updateMedical.setCreated(new Date());
        updateMedical.setUpdated(new Date());
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
                tr.setBedroom(sickRoom.getId());
                tr.setBedRoomName(sickRoom.getName());
            }
            treatList.add(tr);
        }
        result.setRows(treatList);
        //取记录总条数
        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
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
                tr.setBedroom(sickRoom.getId());
                tr.setBedRoomName(sickRoom.getName());
            }
            treatList.add(tr);
        }
        result.setRows(treatList);
        //取记录总条数
        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    public EUDataGridResult searchMedicalByManager(searchParamsWithTime search_params){
        String search_condition = search_params.getSearch_condition();
        String search_key = search_params.getSearch_key();
        Date beginDate = search_params.getBeginDate();
        Date endDate = search_params.getEndDate();
        Integer page = Integer.valueOf(search_params.getPageNumber());
        Integer rows = Integer.valueOf(search_params.getRows());
        TbMedicalExample example = new TbMedicalExample();
        TbMedicalExample.Criteria criteria = example.createCriteria();
        if(search_key.length() != 0){
            if(search_condition.equals("id")){
                BigDecimal id = new BigDecimal(search_key);
                criteria.andIdEqualTo(id);
            }else if(search_condition.equals("positionName")){
                //查询部门id
                TbPositionCatExample example1 = new TbPositionCatExample();
                TbPositionCatExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andNameEqualTo(search_key);
                List<TbPositionCat> positionCat = positionCatMapper.selectByExample(example1);
                if(positionCat.size() != 0){
                    BigDecimal positionCatId = positionCat.get(0).getId();
                    criteria.andOfficeidEqualTo(positionCatId.longValue());
                }else{
                    System.out.println("没有这个部门");
                }
            }else if(search_condition.equals("status")){
                Short status = new Short(search_key);
                criteria.andStatusEqualTo(status);
            }
        }
        if((beginDate != null && endDate != null)){
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(beginDate);
            calendar.add(Calendar.HOUR,-8);
            beginDate = calendar.getTime();
            calendar.setTime(endDate);
            calendar.add(Calendar.HOUR,-8);
            endDate = calendar.getTime();
            criteria.andCreatedBetween(beginDate,endDate);
        }
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
            tr.setTelePhone(user.getTelphone());
            tr.setNickName(user.getNickname());
            tr.setSickname(medical.getSickname());
            tr.setPrice(medical.getPrice());
            tr.setWord(medical.getWords());
            tr.setStartMedicalTime(medical.getCreated());
            tr.setEndMedicalTime(medical.getUpdated());
            tr.setStatus(medical.getStatus());
            if(medical.getBedroom() != null){
                TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(medical.getBedroom());
                tr.setBedroom(sickRoom.getId());
                tr.setBedRoomName(sickRoom.getName());
            }
            treatList.add(tr);
        }
        result.setRows(treatList);
        //取记录总条数
        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    public EUDataGridResult searchMedicalByDoctor(searchParamsWithTime search_params,BigDecimal doctorId){
        String search_condition = search_params.getSearch_condition();
        String search_key = search_params.getSearch_key();
        Date beginDate = search_params.getBeginDate();
        Date endDate = search_params.getEndDate();
        Integer page = Integer.valueOf(search_params.getPageNumber());
        Integer rows = Integer.valueOf(search_params.getRows());
        TbMedicalExample example = new TbMedicalExample();
        TbMedicalExample.Criteria criteria = example.createCriteria();
        criteria.andDoctoridEqualTo(doctorId);
        if(search_key.length() != 0){
            if(search_condition.equals("id")){
                BigDecimal id = new BigDecimal(search_key);
                System.out.println("1111111111");
                criteria.andIdEqualTo(id);
            }else if(search_condition.equals("status")){
                Short status = new Short(search_key);
                criteria.andStatusEqualTo(status);
            }
        }
        if((beginDate != null && endDate != null)){
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(beginDate);
            calendar.add(Calendar.HOUR,-8);
            beginDate = calendar.getTime();
            System.out.println("111111111");
            calendar.setTime(endDate);
            calendar.add(Calendar.HOUR,-8);
            endDate = calendar.getTime();
            criteria.andCreatedBetween(beginDate,endDate);
        }
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
            tr.setTelePhone(user.getTelphone());
            tr.setSickname(medical.getSickname());
            tr.setNickName(user.getNickname());
            tr.setPrice(medical.getPrice());
            tr.setWord(medical.getWords());
            tr.setStartMedicalTime(medical.getCreated());
            tr.setEndMedicalTime(medical.getUpdated());
            tr.setStatus(medical.getStatus());
            if(medical.getBedroom() != null){
                TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(medical.getBedroom());
                tr.setBedroom(sickRoom.getId());
                tr.setBedRoomName(sickRoom.getName());
            }
            treatList.add(tr);
        }
        result.setRows(treatList);
        //取记录总条数
        PageInfo<treat> pageInfo = new PageInfo<>(treatList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public TaotaoResult updateMedicalByDoctor(TbMedical medical){
        Short zero = 0;
        Short one = 1;
        TbMedical updateMedical = medicalMapper.selectByPrimaryKey(medical.getId());
        if(medical.getStatus() == 3){
            TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(medical.getBedroom());
            sickRoom.setStatus(zero);
            sickRoomMapper.updateByPrimaryKey(sickRoom);
            if(updateMedical.getBedroom() != null){
                if(!(updateMedical.getBedroom().equals(medical.getBedroom()))){
                    TbSickRoom sickRoom1 = sickRoomMapper.selectByPrimaryKey(updateMedical.getBedroom());
                    sickRoom1.setStatus(one);
                    sickRoomMapper.updateByPrimaryKey(sickRoom1);
                }
            }
            updateMedical.setBedroom(medical.getBedroom());
        }else{
            if(updateMedical.getBedroom() != null){
                TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(updateMedical.getBedroom());
                sickRoom.setStatus(one);
                sickRoomMapper.updateByPrimaryKey(sickRoom);
                updateMedical.setBedroom(null);
            }
        }
        updateMedical.setSickname(medical.getSickname());
        updateMedical.setStatus(medical.getStatus());
        updateMedical.setUpdated(new Date());
        medicalMapper.updateByPrimaryKey(updateMedical);
        return TaotaoResult.ok();
    }
    @Override
    public boolean IsChangeBedRoom(TbMedical medical){
        TbMedical updateMedical = medicalMapper.selectByPrimaryKey(medical.getId());
        if(updateMedical.getBedroom() != null){
            if(updateMedical.getBedroom().equals(medical.getBedroom())){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean judgeMedicalCanChangeFour(BigDecimal medicalId){
        Short one = 1;
        Short three = 3;
        TbMedicalDetailExample example = new TbMedicalDetailExample();
        TbMedicalDetailExample.Criteria criteria = example.createCriteria();
        criteria.andStatusBetween(one,three);
        List<TbMedicalDetail> medicalDetailList = medicalDetailMapper.selectByExample(example);
        if(medicalDetailList.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean judgeMedicalCanChangeZero(BigDecimal medicalId){
        Short one = 1;
        Short four = 4;
        TbMedicalDetailExample example = new TbMedicalDetailExample();
        TbMedicalDetailExample.Criteria criteria = example.createCriteria();
        criteria.andStatusBetween(one,four);
        List<TbMedicalDetail> medicalDetailList = medicalDetailMapper.selectByExample(example);
        if(medicalDetailList.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public TaotaoResult updateMedicalByManager(TbMedical medical){
        Short one = 1;
        boolean flag1 = true;
        boolean flag2 = true;
        if(medical.getStatus() == 4){
            flag1 = judgeMedicalCanChangeFour(medical.getId());
            System.out.println(flag1);
        }
        if(medical.getStatus() == 0){
            flag2 = judgeMedicalCanChangeZero(medical.getId());
            System.out.println(flag2);
        }
        if(flag1&&flag2){
            TbMedical updateMedical = medicalMapper.selectByPrimaryKey(medical.getId());
            if(updateMedical.getBedroom() != null){
                TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(updateMedical.getBedroom());
                sickRoom.setStatus(one);
                sickRoomMapper.updateByPrimaryKey(sickRoom);
            }
            updateMedical.setStatus(medical.getStatus());
            medicalMapper.updateByPrimaryKey(updateMedical);
            return TaotaoResult.ok();
        }else{
            return TaotaoResult.build(500,"该病历还有未处理完的治疗记录");
        }
    }
}
