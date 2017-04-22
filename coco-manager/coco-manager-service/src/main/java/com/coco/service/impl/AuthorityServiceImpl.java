package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbAuthorityMapper;
import com.coco.mapper.TbModuleMapper;
import com.coco.pojo.TbAuthority;
import com.coco.pojo.TbAuthorityExample;
import com.coco.pojo.TbModule;
import com.coco.pojo.authorityView;
import com.coco.service.AuthorityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/22 0022.
 */
@Service
public class AuthorityServiceImpl implements AuthorityService{
    @Autowired
    private TbAuthorityMapper authorityMapper;
    @Autowired
    private TbModuleMapper moduleMapper;
    @Override
    public TaotaoResult createAuthority(TbAuthority authority){
        Long authorityId = IDUtils.genItemId();
        BigDecimal authority_id = new BigDecimal(authorityId);
        authority.setId(authority_id);
        authority.setUpdated(new Date());
        authority.setCreated(new Date());
        authorityMapper.insert(authority);
        return TaotaoResult.ok();
    }
    @Override
    public EUDataGridResult getAuthorityList(Integer page, Integer rows){
        //查询商品列表
        TbAuthorityExample example = new TbAuthorityExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbAuthority> list = authorityMapper.selectByExample(example);
        //创建一个返回值对象
        List<authorityView> authorityList = new ArrayList<>();
        EUDataGridResult result = new EUDataGridResult();
        for(TbAuthority authority : list){
            authorityView authorityView1 = new authorityView();
            authorityView1.setId(authority.getId());
            authorityView1.setUserId(authority.getUserid());
            authorityView1.setCreated(authority.getCreated());
            authorityView1.setUpdated(authority.getUpdated());
            TbModule module = moduleMapper.selectByPrimaryKey(authority.getModuleId());
            authorityView1.setModuleName(module.getName());
            authorityList.add(authorityView1);
        }
        result.setRows(authorityList);
        //取记录总条数
        PageInfo<authorityView> pageInfo = new PageInfo<>(authorityList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public EUDataGridResult searchAuthority(BigDecimal id,Integer page,Integer rows){
        TbAuthorityExample example = new TbAuthorityExample();
        TbAuthorityExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(id);
        PageHelper.startPage(page, rows);
        List<TbAuthority> list = authorityMapper.selectByExample(example);
        List<authorityView> authorityList = new ArrayList<>();
        EUDataGridResult result = new EUDataGridResult();
        for(TbAuthority authority : list){
            authorityView authorityView1 = new authorityView();
            authorityView1.setId(authority.getId());
            authorityView1.setCreated(authority.getCreated());
            authorityView1.setUserId(authority.getUserid());
            authorityView1.setUpdated(authority.getUpdated());
            TbModule module = moduleMapper.selectByPrimaryKey(authority.getModuleId());
            authorityView1.setModuleName(module.getName());
            authorityList.add(authorityView1);
        }
        result.setRows(authorityList);
        //取记录总条数
        PageInfo<authorityView> pageInfo = new PageInfo<>(authorityList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
