package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbUserMapper;
import com.coco.pojo.TbUser;
import com.coco.pojo.TbUserExample;
import com.coco.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;
    @Override
    public TbUser selectLoginUser(String username, String password){
        Short zero = 0;
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginnameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        criteria.andStatusNotEqualTo(zero);
        List<TbUser> list = userMapper.selectByExample(example);
        if(list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }
    @Override
    public boolean checkRegisterName(String registerName){
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginnameEqualTo(registerName);
        List<TbUser> list = userMapper.selectByExample(example);
        if(list.size() == 0){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public boolean checkRegisterNickName(String registerNickName){
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andNicknameEqualTo(registerNickName);
        List<TbUser> list = userMapper.selectByExample(example);
        if(list.size() == 0){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public TaotaoResult userRegister(String registerUserName,String registerPassWord,
                                String nickName,String telePhone){
        try{
            Long userId = IDUtils.genItemId();
            BigDecimal user_id = new BigDecimal(userId);
            TbUser tbUser = new TbUser();
            tbUser.setId(user_id);
            tbUser.setLoginname(registerUserName);
            tbUser.setPassword(registerPassWord);
            tbUser.setNickname(nickName);
            tbUser.setTelphone(telePhone);
            Short status = 1;
            tbUser.setStatus(status);
            tbUser.setCreated(new Date());
            tbUser.setUpdated(new Date());
            userMapper.insert(tbUser);
            return TaotaoResult.build(200,"注册成功");
        }catch(Exception e){
            String s = e.getCause().toString();
            return TaotaoResult.build(500,s);
        }
    }
    @Override
    public boolean isVIP(BigDecimal userId){
        TbUser user = userMapper.selectByPrimaryKey(userId);
        Short vipStatus = 2;
        if(user.getStatus() == vipStatus){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public EUDataGridResult getAccountList(Integer page, Integer rows){
        TbUserExample example = new TbUserExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbUser> list = userMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbUser> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public TaotaoResult updateAccountByManager(TbUser user) throws Exception{
        BigDecimal id = user.getId();
        TbUser account = userMapper.selectByPrimaryKey(id);
        account.setStatus(user.getStatus());
        account.setUpdated(new Date());
        userMapper.updateByPrimaryKey(account);
        return TaotaoResult.ok();
    }
    @Override
    public EUDataGridResult searchAccountList(String search_condition,String search_key,Integer page,Integer rows){
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        if(search_condition.equals("id")){
            BigDecimal id = new BigDecimal(search_key);
            criteria.andIdEqualTo(id);
        }else if(search_condition.equals("loginname")){
            criteria.andLoginnameEqualTo(search_key);
        }else if(search_condition.equals("nickname")){
            criteria.andNicknameEqualTo(search_key);
        }else if(search_condition.equals("status")){
            Short status = new Short(search_key);
            criteria.andStatusEqualTo(status);
        }
        PageHelper.startPage(page, rows);
        List<TbUser> list = userMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbUser> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
