package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbEmployeeMapper;
import com.coco.pojo.TbEmployee;
import com.coco.pojo.TbEmployeeExample;
import com.coco.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private TbEmployeeMapper employeeMapper;
    @Override
    public TaotaoResult createEmployee(TbEmployee employee) throws Exception{
        Long employeeId = IDUtils.genItemId();
        BigDecimal employee_id = new BigDecimal(employeeId);
        employee.setId(employee_id);
        employee.setCreated(new Date());
        employee.setUpdated(new Date());
        employeeMapper.insert(employee);
        return TaotaoResult.ok();
    }
    @Override
    public EUDataGridResult getEmployeeList(int page, int rows){
        //查询商品列表
        TbEmployeeExample example = new TbEmployeeExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbEmployee> list = employeeMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbEmployee> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult updateEmployee(TbEmployee employee) throws Exception{
        System.out.println(employee.getStatus());
        System.out.println(employee.getSex());
        employee.setCreated(null);
        employee.setUpdated(new Date());
        employeeMapper.updateByPrimaryKey(employee);
        return TaotaoResult.ok();
    }

    @Override
    public EUDataGridResult searchEmployeeList(String search_condition,String search_key,Integer page,Integer rows){
        System.out.println("service"  + search_condition);
        System.out.println("service" + search_key);
        TbEmployeeExample example = new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria = example.createCriteria();
        if(search_condition.equals("id")){
            BigDecimal id = new BigDecimal(search_key);
            criteria.andIdEqualTo(id);
        }else if(search_condition.equals("name")){
            criteria.andNameEqualTo(search_key);
        }else if(search_condition.equals("sex")){
            criteria.andSexEqualTo(search_key);
        }else if(search_condition.equals("cid")){
            Long cid = Long.parseLong(search_key);
            criteria.andCidEqualTo(cid);
        }else if(search_condition.equals("status")){
            Short status = new Short(search_key);
            criteria.andStatusEqualTo(status);
        }
        PageHelper.startPage(page, rows);
        List<TbEmployee> list = employeeMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbEmployee> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
