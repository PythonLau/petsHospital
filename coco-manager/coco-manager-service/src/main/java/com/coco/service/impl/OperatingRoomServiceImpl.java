package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNode;
import com.coco.mapper.TbOperatingRoomMapper;
import com.coco.pojo.TbOperatingRoom;
import com.coco.pojo.TbOperatingRoomExample;
import com.coco.service.OperatingRoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        Short judgeOne = 1;
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
            System.out.println("22222222");
            node.setText(operatingRoom.getName());
            Short status = operatingRoom.getIsParent();
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
    public List<EUTreeNode> getRoomTreeListByManager(BigDecimal parentId){
        Short judgeOne = 1;
        TbOperatingRoomExample example = new TbOperatingRoomExample();
        TbOperatingRoomExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //根据条件查询
        List<TbOperatingRoom> list = operatingRoomMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        //把列表转换成treeNodelist
        for (TbOperatingRoom operatingRoom : list) {
            EUTreeNode node = new EUTreeNode();
            node.setId(operatingRoom.getId());
            node.setText(operatingRoom.getName());
            Short status = operatingRoom.getIsParent();
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
    public EUDataGridResult getRoomListByManager(Integer page, Integer rows){
        TbOperatingRoomExample example = new TbOperatingRoomExample();
        PageHelper.startPage(page, rows);
        List<TbOperatingRoom> list = operatingRoomMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbOperatingRoom> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
