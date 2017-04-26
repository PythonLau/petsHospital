package com.coco.service;


import com.coco.common.pojo.EUDataGridResult;
import com.coco.pojo.TbDoctor;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
public interface DoctorService {
    TbDoctor getDoctor(String username, String password);
    EUDataGridResult getDoctorAccountList(Integer page, Integer rows);
}
