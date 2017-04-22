package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.searchParamsWithTime;
import com.coco.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @RequestMapping("/report/search")
    @ResponseBody
    public EUDataGridResult searchReport(@RequestBody searchParamsWithTime search_params) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = search_params.getBeginDate();
        Date endDate = search_params.getEndDate();
        Integer page = Integer.valueOf(search_params.getPageNumber());
        Integer rows = Integer.valueOf(search_params.getRows());
        if(beginDate != null && endDate != null){
            String begin_date = sdf.format(beginDate);
            String end_date = sdf.format(endDate);
            EUDataGridResult result = reportService.searchReport(begin_date,end_date,page,rows);
            return result;
        }else{
            return null;
        }
    }
}
