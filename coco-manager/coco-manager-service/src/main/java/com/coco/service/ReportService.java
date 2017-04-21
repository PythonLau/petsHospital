package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;

/**
 * Created by Administrator on 2017/4/21 0021.
 */
public interface ReportService {
    EUDataGridResult getReport(Integer page, Integer rows);
}
