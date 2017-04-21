package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/4/21 0021.
 */
@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;
    @RequestMapping("/report/flowAndAchievement")
    @ResponseBody
    public EUDataGridResult getReport(Integer page, Integer rows){
        EUDataGridResult result = reportService.getReport(page,rows);
        return result;
    }
}
