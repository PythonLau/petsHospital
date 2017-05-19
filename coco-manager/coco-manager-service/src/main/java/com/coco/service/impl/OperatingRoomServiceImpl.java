package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbMedicalDetailMapper;
import com.coco.mapper.TbOperatingRoomMapper;
import com.coco.pojo.TbMedicalDetail;
import com.coco.pojo.TbMedicalDetailExample;
import com.coco.pojo.TbOperatingRoom;
import com.coco.pojo.TbOperatingRoomExample;
import com.coco.service.OperatingRoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
@Service
public class OperatingRoomServiceImpl implements OperatingRoomService {
    @Autowired
    private TbOperatingRoomMapper operatingRoomMapper;
    @Autowired
    private TbMedicalDetailMapper medicalDetailMapper;
    public List<EUTreeNode> getOperatingRoomList(BigDecimal parentId){
        Short judgeOne = 1;
        Short one = 1;
        TbOperatingRoomExample example = new TbOperatingRoomExample();
        TbOperatingRoomExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andStatusEqualTo(one);
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
        Short two = 2;
        Short judgeOne = 1;
        TbOperatingRoomExample example = new TbOperatingRoomExample();
        TbOperatingRoomExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andStatusNotEqualTo(two);
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
    @Override
    public TaotaoResult createRoomByManager(BigDecimal parentId,String name){
        Short one = 1;
        Short zero = 0;
        TbOperatingRoom operatingRoom = new TbOperatingRoom();
        Long roomId = IDUtils.genItemId();
        BigDecimal room_Id = new BigDecimal(roomId);
        operatingRoom.setId(room_Id);
        operatingRoom.setName(name);
        operatingRoom.setParentId(parentId);
        operatingRoom.setStatus(one);
        operatingRoom.setIsParent(zero);
        operatingRoom.setSortOrder(one);
        operatingRoom.setCreated(new Date());
        operatingRoom.setUpdated(new Date());
        operatingRoomMapper.insert(operatingRoom);
        TbOperatingRoom parentSickRoom = operatingRoomMapper.selectByPrimaryKey(parentId);
        if(parentSickRoom.getIsParent() == zero) {
            parentSickRoom.setIsParent(one);
            //更新父节点
            operatingRoomMapper.updateByPrimaryKey(parentSickRoom);
        }
        return TaotaoResult.ok();
    }
    @Override
    public TaotaoResult updateRoomByManager(BigDecimal id,String name){
        TbOperatingRoom operatingRoom = operatingRoomMapper.selectByPrimaryKey(id);
        operatingRoom.setName(name);
        operatingRoomMapper.updateByPrimaryKey(operatingRoom);
        return TaotaoResult.ok();
    }
    @Override
    public TaotaoResult deleteRoomByManager(BigDecimal id){
        Short two = 2;
        Short zero = 0;
        boolean canDelete = judgeRoomCanDelete(id);
        if(canDelete){
            //查询要删除节点自身的实例
            TbOperatingRoom operatingRoom = operatingRoomMapper.selectByPrimaryKey(id);
            //找出他的父节点ID
            BigDecimal parentId = operatingRoom.getParentId();
            //删除Example，并且删除
            TbOperatingRoom operatingRoom1 = operatingRoomMapper.selectByPrimaryKey(id);
            operatingRoom1.setStatus(two);
            operatingRoomMapper.updateByPrimaryKey(operatingRoom1);
            TbOperatingRoomExample example1 = new TbOperatingRoomExample();
            TbOperatingRoomExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andParentIdEqualTo(parentId);
            List<TbOperatingRoom> list = operatingRoomMapper.selectByExample(example1);
            if(list.size() == 0){
                TbOperatingRoom parentOperatingRoom = operatingRoomMapper.selectByPrimaryKey(parentId);
                parentOperatingRoom.setIsParent(zero);
                operatingRoomMapper.updateByPrimaryKey(parentOperatingRoom);
            }
            return TaotaoResult.build(200,"删除分类成功");
        }else{
            return TaotaoResult.build(500,"需要清空该分类下所有的分类以及物品才能删除该分类");
        }
    }
    @Override
    public boolean judgeRoomCanDelete(BigDecimal id){
        Short one = 1;
        Short three = 3;
        TbOperatingRoomExample example = new TbOperatingRoomExample();
        TbOperatingRoomExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<TbOperatingRoom> operatingRoomList = operatingRoomMapper.selectByExample(example);
        if(operatingRoomList.size() == 0){
            TbMedicalDetailExample example1 = new TbMedicalDetailExample();
            TbMedicalDetailExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andStatusBetween(one,three);
            criteria1.andRoomEqualTo(id);
            List<TbMedicalDetail> medicalDetailList = medicalDetailMapper.selectByExample(example1);
            if(medicalDetailList.size() == 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    @Override
    public Short getOperatingRoomStatus(BigDecimal id){
        TbOperatingRoom operatingRoom = operatingRoomMapper.selectByPrimaryKey(id);
        return operatingRoom.getStatus();
    }
}
