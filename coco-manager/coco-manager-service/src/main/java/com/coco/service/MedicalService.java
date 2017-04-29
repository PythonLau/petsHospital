package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.pojo.searchParamsWithTime;
import com.coco.pojo.CaseHistory;
import com.coco.pojo.TbMedical;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
public interface MedicalService {
    TaotaoResult registerMedical(BigDecimal id, Long cid, String name, Date registerDate);
    Page<CaseHistory> getCaseHistory(Integer pageNumber, BigDecimal petId);
    TaotaoResult cancelMedical(BigDecimal caseHistoryId);
    BigDecimal getPetId(BigDecimal caseHistoryId);
    EUDataGridResult getTreatList(int page, int rows,BigDecimal userId);
    TaotaoResult acceptMedical(TbMedical medical);
    EUDataGridResult getMedicalListByDoctor(Integer page,Integer rows,BigDecimal userId);
    EUDataGridResult getMedicalOrderList(Integer page, Integer rows);
//    TaotaoResult updatePrescribeByManager(BigDecimal medicalId,Short status,BigDecimal price);
    EUDataGridResult searchMedicalByManager(searchParamsWithTime search_params);
    EUDataGridResult searchMedicalByDoctor(searchParamsWithTime search_params,BigDecimal doctorId);
    EUDataGridResult searchTreatByDoctor(searchParamsWithTime search_params,BigDecimal doctorId);
}
