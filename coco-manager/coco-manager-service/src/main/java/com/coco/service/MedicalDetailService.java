package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbMedicalDetail;
import com.coco.pojo.medicalRecord;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public interface MedicalDetailService {
    TaotaoResult saveMedicalDetail(TbMedicalDetail medicalDetail);
    EUDataGridResult getMedicalDetailByDoctor(BigDecimal medicalId,Integer page,Integer rows);
    EUDataGridResult getMedicalDetailByManager(BigDecimal medicalId,Integer page,Integer rows);
    TaotaoResult updateMedicalDetailByManager(TbMedicalDetail medicalDetail);
    Page<medicalRecord> getMedicalRecord(Integer pageNumber, BigDecimal medicalId);
}
