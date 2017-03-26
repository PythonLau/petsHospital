package com.coco.service.impl;

import com.coco.mapper.TbManagerMapper;
import com.coco.pojo.TbManager;
import com.coco.pojo.TbManagerExample;
import com.coco.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private TbManagerMapper managerMapper;
    public boolean IsManagerExist(String username,String password){
        TbManagerExample example = new TbManagerExample();
        TbManagerExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<TbManager> list = managerMapper.selectByExample(example);
        if(list.size() == 0){
            return false;
        }else{
            return true;
        }
    }
}
