package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/21 0021.
 */
public interface ReportService {
    EUDataGridResult getReport(Integer page, Integer rows);
    EUDataGridResult searchReport(String beginDate, String endDate, Integer page, Integer rows);
}
