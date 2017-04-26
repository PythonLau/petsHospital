package com.coco.service.impl;

import com.coco.common.pojo.EUTreeNode;
import com.coco.mapper.TbSickRoomMapper;
import com.coco.pojo.TbSickRoom;
import com.coco.pojo.TbSickRoomExample;
import com.coco.service.SickRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/23 0023.
 */
@Service
public class SickRoomServiceImpl implements SickRoomService {
    @Autowired
    private TbSickRoomMapper sickRoomMapper;
    @Override
    public List<EUTreeNode> getBedRoomListByDoctor(BigDecimal parentId){
        TbSickRoomExample example = new TbSickRoomExample();
        TbSickRoomExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        Short one = 1;
        criteria.andStatusEqualTo(one);
        List<TbSickRoom> list = sickRoomMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        for (TbSickRoom sickRoom : list) {
            EUTreeNode node = new EUTreeNode();
            node.setText(sickRoom.getName());
            node.setId(sickRoom.getId());
            Short status = sickRoom.getIsParent();
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
}
