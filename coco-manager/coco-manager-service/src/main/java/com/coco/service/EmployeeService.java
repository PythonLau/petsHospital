package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbEmployee;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
public interface EmployeeService {
    TaotaoResult createEmployee(TbEmployee employee) throws Exception;
    EUDataGridResult getEmployeeList(int page, int rows);
    TaotaoResult updateEmployee(TbEmployee employee) throws Exception;
}
