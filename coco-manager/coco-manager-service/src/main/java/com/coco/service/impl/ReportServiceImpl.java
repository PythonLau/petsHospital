package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.mapper.TbFlowAchievementReportMapper;
import com.coco.pojo.TbFlowAchievementReport;
import com.coco.pojo.TbFlowAchievementReportExample;
import com.coco.service.ReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21 0021.
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private TbFlowAchievementReportMapper flowAchievementReportMapper;
    @Override
    public EUDataGridResult getReport(Integer page, Integer rows){
        TbFlowAchievementReportExample example = new TbFlowAchievementReportExample();
        example.setOrderByClause("serverdate desc");
        PageHelper.startPage(page, rows);
        List<TbFlowAchievementReport> list = flowAchievementReportMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbFlowAchievementReport> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public EUDataGridResult searchReport(String beginDate, String endDate, Integer page, Integer rows){
        TbFlowAchievementReportExample example = new TbFlowAchievementReportExample();
        TbFlowAchievementReportExample.Criteria criteria = example.createCriteria();
        criteria.andServerdateBetween(beginDate,endDate);
        System.out.println(beginDate);
        System.out.println(endDate);
        PageHelper.startPage(page, rows);
        List<TbFlowAchievementReport> list = flowAchievementReportMapper.selectByExample(example);
        System.out.println(list.size());
        System.out.println(list);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbFlowAchievementReport> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        System.out.println("rows:" + result.getRows());
        System.out.println("total:" + result.getTotal());
        return result;
    }
}
