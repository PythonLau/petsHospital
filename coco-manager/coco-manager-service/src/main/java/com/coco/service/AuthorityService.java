package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbAuthority;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public interface AuthorityService {
    TaotaoResult createAuthority(TbAuthority authority);
    EUDataGridResult getAuthorityList(Integer page,Integer rows);
    EUDataGridResult searchAuthority(BigDecimal id, Integer page, Integer rows);
    TaotaoResult deleteAuthority(String ids) throws Exception;
}
