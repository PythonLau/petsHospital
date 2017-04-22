package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNodeWithAttributes;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbAuthorityMapper;
import com.coco.mapper.TbLoginMapper;
import com.coco.mapper.TbModuleMapper;
import com.coco.pojo.*;
import com.coco.service.ModuleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private TbModuleMapper moduleMapper;
    @Autowired
    private TbLoginMapper loginMapper;
    @Autowired
    private TbAuthorityMapper authorityMapper;
    private Short isTrue = 1;
    private Short isFalse = 0;
    @Override
    public List<EUTreeNodeWithAttributes> getModuleList(BigDecimal parentId,BigDecimal userId){
        //创建查询条件
        TbLogin user = loginMapper.selectByPrimaryKey(userId);
        Short status = user.getStatus();
        Short one = 1;
        Short two = 2;
        if(status == two){
            return getManagerModuleList(parentId);
        }else if(status == one){
            return getUserModuleList(userId,parentId);
        }
        return null;
    }
    @Override
    public List<EUTreeNodeWithAttributes> getManagerModuleList(BigDecimal parentId){
        TbModuleExample example = new TbModuleExample();
        TbModuleExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //根据条件查询
        List<TbModule> list = moduleMapper.selectByExample(example);
        List<EUTreeNodeWithAttributes> resultList = new ArrayList<>();
        //把列表转换成treeNodelist
        for (TbModule tbModule : list) {
            EUTreeNodeWithAttributes node = new EUTreeNodeWithAttributes();
            node.setId(tbModule.getId());
            node.setText(tbModule.getName());
            Map attributes = new HashMap<>();
            attributes.put("url",tbModule.getUrl());
            node.setAttributes(attributes);
            Short status = tbModule.getIsParent();
            Short judgeOne = 1;
            if(status.equals(judgeOne)){
                node.setState("closed");
            }else{
                node.setState("open");
            }
            resultList.add(node);
        }
        //返回结果
        System.out.println("1111");
        return resultList;
    }
    @Override
    public List<EUTreeNodeWithAttributes> getUserModuleList(BigDecimal userId,BigDecimal parentId){
        TbModuleExample example = new TbModuleExample();
        TbModuleExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //根据条件查询
        List<TbModule> list = moduleMapper.selectByExample(example);
        List<EUTreeNodeWithAttributes> resultList = new ArrayList<>();
        List<TbAuthority> authorities = getAuthority(userId);
        for(TbModule module : list){
            EUTreeNodeWithAttributes node = new EUTreeNodeWithAttributes();
            for(TbAuthority authority: authorities){
                System.out.println("11111111111111");
                System.out.println(authority.getModuleId());
                System.out.println(module.getId());
                System.out.println("22222222222222");
                if(authority.getModuleId().equals(module.getId())){
                    System.out.println("3333333333333");
                    node.setId(module.getId());
                    node.setText(module.getName());
                    Map attributes = new HashMap<>();
                    attributes.put("url",module.getUrl());
                    node.setAttributes(attributes);
                    Short status = module.getIsParent();
                    Short judgeOne = 1;
                    if(status.equals(judgeOne)){
                        node.setState("closed");
                    }else{
                        node.setState("open");
                    }
                    resultList.add(node);
                }
            }
        }
        return resultList;
    }
    @Override
    public List<TbAuthority> getAuthority(BigDecimal userId){
        TbAuthorityExample example1 = new TbAuthorityExample();
        TbAuthorityExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUseridEqualTo(userId);
        List<TbAuthority> authorityList = authorityMapper.selectByExample(example1);
        return authorityList;
    }
    @Override
    public List<EUTreeNodeWithAttributes> getModuleListByManager(BigDecimal parentId){
        TbModuleExample example = new TbModuleExample();
        TbModuleExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbModule> list = moduleMapper.selectByExample(example);
        List<EUTreeNodeWithAttributes> resultList = new ArrayList<>();
        for (TbModule module : list) {
            EUTreeNodeWithAttributes node = new EUTreeNodeWithAttributes();
            node.setId(module.getId());
            System.out.println("2222222222");
            node.setText(module.getName());
            Short status = module.getIsParent();
            Short judgeOne = 1;
            if(status.equals(judgeOne)){
                node.setState("closed");
            }else{
                node.setState("open");
            }
            resultList.add(node);
        }
        //返回结果
        return resultList;
    }
    @Override
    public TaotaoResult createModule(BigDecimal parentId, String name){
        TbModule module = new TbModule();
        Long moduleId = IDUtils.genItemId();
        BigDecimal module_Id = new BigDecimal(moduleId);
        module.setId(module_Id);
        module.setParentId(parentId);
        module.setName(name);
        module.setIsParent(isFalse);
        module.setStatus(isTrue);
        module.setSortOrder(isTrue);
        moduleMapper.insert(module);
        TbModule parentModule = moduleMapper.selectByPrimaryKey(parentId);
        if(parentModule.getIsParent() == isFalse) {
            parentModule.setIsParent(isTrue);
            //更新父节点
            moduleMapper.updateByPrimaryKey(parentModule);
        }
        return TaotaoResult.ok(module);
    }
    @Override
    public TaotaoResult updateModule(BigDecimal id,String name){
        TbModule module = moduleMapper.selectByPrimaryKey(id);
        module.setName(name);
        moduleMapper.updateByPrimaryKey(module);
        return TaotaoResult.ok();
    }
    @Override
    public TaotaoResult deleteModule(BigDecimal id){
        moduleMapper.deleteByPrimaryKey(id);
        return TaotaoResult.ok();
    }
    @Override
    public EUDataGridResult getModuleEditList(Integer page,Integer rows){
        TbModuleExample example = new TbModuleExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbModule> list = moduleMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbModule> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public TaotaoResult updateModuleDetail(TbModule module){
        TbModule updateModule = moduleMapper.selectByPrimaryKey(module.getId());
        updateModule.setName(module.getName());
        updateModule.setSortOrder(module.getSortOrder());
        updateModule.setUrl(module.getUrl());
        System.out.println("status : " + module.getStatus());
        updateModule.setStatus(module.getStatus());
        moduleMapper.updateByPrimaryKey(updateModule);
        return TaotaoResult.ok();
    }
    @Override
    public EUDataGridResult searchModule(String name,Integer page,Integer rows){
        TbModuleExample example = new TbModuleExample();
        TbModuleExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike(name);
        PageHelper.startPage(page, rows);
        List<TbModule> list = moduleMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbModule> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
