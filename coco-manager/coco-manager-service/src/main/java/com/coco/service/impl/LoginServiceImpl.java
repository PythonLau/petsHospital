package com.coco.service.impl;

import com.coco.mapper.TbLoginMapper;
import com.coco.pojo.TbLogin;
import com.coco.pojo.TbLoginExample;
import com.coco.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private TbLoginMapper loginMapper;
    @Override
    public TbLogin getUser(String username, String password){
        TbLoginExample example = new TbLoginExample();
        TbLoginExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<TbLogin> list = loginMapper.selectByExample(example);
        if(list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }
}
