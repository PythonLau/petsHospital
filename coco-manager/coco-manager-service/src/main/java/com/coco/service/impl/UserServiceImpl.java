package com.coco.service.impl;

import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbUserMapper;
import com.coco.pojo.TbUser;
import com.coco.pojo.TbUserExample;
import com.coco.service.UserService;
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
    public TbUser selectLoginUser(String username, String password){
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginnameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<TbUser> list = userMapper.selectByExample(example);
        if(list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }
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
}
