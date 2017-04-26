package com.coco.service.impl;

import com.coco.common.pojo.EUTreeNode;
import com.coco.mapper.TbOperatingRoomMapper;
import com.coco.pojo.TbOperatingRoom;
import com.coco.pojo.TbOperatingRoomExample;
import com.coco.service.OperatingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
@Service
public class OperatingRoomServiceImpl implements OperatingRoomService {
    @Autowired
    private TbOperatingRoomMapper operatingRoomMapper;
    public List<EUTreeNode> getOperatingRoomList(BigDecimal parentId){
        TbOperatingRoomExample example = new TbOperatingRoomExample();
        TbOperatingRoomExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //根据条件查询
        List<TbOperatingRoom> list = operatingRoomMapper.selectByExample(example);
        System.out.println("size...");
        System.out.println(list.size());
        List<EUTreeNode> resultList = new ArrayList<>();
        //把列表转换成treeNodelist
        for (TbOperatingRoom operatingRoom : list) {
            EUTreeNode node = new EUTreeNode();
            node.setId(operatingRoom.getId());
            node.setText(operatingRoom.getName());
            Short status = operatingRoom.getIsParent();
            System.out.println("11111111");
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
