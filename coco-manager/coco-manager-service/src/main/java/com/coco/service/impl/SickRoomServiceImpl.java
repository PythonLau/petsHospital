package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;
import com.coco.mapper.TbSickRoomMapper;
import com.coco.pojo.TbSickRoom;
import com.coco.pojo.TbSickRoomExample;
import com.coco.service.SickRoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @Override
    public Short getSickRoomStatus(BigDecimal sickRoomId){
        TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(sickRoomId);
        return sickRoom.getStatus();
    }
    @Override
    public List<EUTreeNode> getBedTreeByManager(BigDecimal parentId){
        Short judgeOne = 1;
        TbSickRoomExample example = new TbSickRoomExample();
        TbSickRoomExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbSickRoom> list = sickRoomMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        for (TbSickRoom sickRoom : list) {
            EUTreeNode node = new EUTreeNode();
            node.setText(sickRoom.getName());
            node.setId(sickRoom.getId());
            Short status = sickRoom.getIsParent();
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
    public EUDataGridResult getBedListByManager(Integer page, Integer rows){
        TbSickRoomExample example = new TbSickRoomExample();
        PageHelper.startPage(page, rows);
        List<TbSickRoom> list = sickRoomMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbSickRoom> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    @Override
    public TaotaoResult createBed(BigDecimal parentId, String name){
        
    }
}
