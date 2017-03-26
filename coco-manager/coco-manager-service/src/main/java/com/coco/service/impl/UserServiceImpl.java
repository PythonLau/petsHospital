package com.coco.service.impl;

import com.coco.mapper.TbUserMapper;
import com.coco.pojo.TbUser;
import com.coco.pojo.TbUserExample;
import com.coco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
