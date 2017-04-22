package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNodeWithAttributes;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbAuthority;
import com.coco.pojo.TbModule;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public interface ModuleService {
    List<EUTreeNodeWithAttributes> getModuleList(BigDecimal parentId,BigDecimal userId);
    List<EUTreeNodeWithAttributes> getManagerModuleList(BigDecimal parentId);
    List<EUTreeNodeWithAttributes> getUserModuleList(BigDecimal userId,BigDecimal parentId);
    List<TbAuthority> getAuthority(BigDecimal userId);
    List<EUTreeNodeWithAttributes> getModuleListByManager(BigDecimal parentId);
    TaotaoResult createModule(BigDecimal parentId, String name);
    TaotaoResult updateModule(BigDecimal id,String name);
    TaotaoResult deleteModule(BigDecimal id);
    EUDataGridResult getModuleEditList(Integer page, Integer rows);
    TaotaoResult updateModuleDetail(TbModule module);
    EUDataGridResult searchModule(String name,Integer page,Integer rows);
}
