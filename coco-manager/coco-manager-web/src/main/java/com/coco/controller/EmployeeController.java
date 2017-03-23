package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.pojo.search_params;
import com.coco.pojo.TbEmployee;
import com.coco.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/employee/save", method= RequestMethod.POST)
    @ResponseBody
    private TaotaoResult createEmployee(TbEmployee employee) throws Exception {
        System.out.println(employee.getCid());
        System.out.println(employee.getName());
        System.out.println(employee.getSex());
        System.out.println(employee.getStatus());
        TaotaoResult result = employeeService.createEmployee(employee);
        return result;
    }

    @RequestMapping("/employee/list")
    @ResponseBody
    public EUDataGridResult getEmployeeList(Integer page, Integer rows) {
        System.out.println(page);
        System.out.println(rows);
        System.out.println("employeelist...controller");
        EUDataGridResult result = employeeService.getEmployeeList(page, rows);
        return result;
    }

    @RequestMapping(value="/employee/update", method=RequestMethod.POST)
    @ResponseBody
    private TaotaoResult updateEmployee(TbEmployee employee) throws Exception {
        System.out.println("employee update controller");
        TaotaoResult result = employeeService.updateEmployee(employee);
        return result;
    }

    @RequestMapping(value="/employee/search", method=RequestMethod.POST)
    @ResponseBody
    private EUDataGridResult searchEmployee(@RequestBody search_params search_params) throws Exception {
        System.out.println("employee search controller");
        String search_condition = search_params.getSearch_condition();
        String search_key = search_params.getSearch_key();
        Integer page = Integer.valueOf(search_params.getPageNumber());
        Integer rows = Integer.valueOf(search_params.getRows());
        System.out.println("page=" + page);
        System.out.println("rows=" + rows);
        System.out.println("search...controller");
        EUDataGridResult result = employeeService.searchEmployeeList(search_condition,search_key,page,rows);
        return result;
    }
}
