package com.coco.service;

import com.coco.common.pojo.EUTreeNodeWithAttributes;
import com.coco.pojo.TbAuthority;

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
}
