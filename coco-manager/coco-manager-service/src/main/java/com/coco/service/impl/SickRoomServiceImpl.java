package com.coco.service.impl;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbMedicalMapper;
import com.coco.mapper.TbSickRoomMapper;
import com.coco.pojo.TbMedical;
import com.coco.pojo.TbMedicalExample;
import com.coco.pojo.TbSickRoom;
import com.coco.pojo.TbSickRoomExample;
import com.coco.service.SickRoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/23 0023.
 */
@Service
public class SickRoomServiceImpl implements SickRoomService {
    @Autowired
    private TbSickRoomMapper sickRoomMapper;
    @Autowired
    private TbMedicalMapper medicalMapper;
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
        Short two = 2;
        Short judgeOne = 1;
        TbSickRoomExample example = new TbSickRoomExample();
        TbSickRoomExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andStatusNotEqualTo(two);
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
        Short one = 1;
        Short zero = 0;
        TbSickRoom sickRoom = new TbSickRoom();
        Long bedId = IDUtils.genItemId();
        BigDecimal bed_id = new BigDecimal(bedId);
        sickRoom.setId(bed_id);
        sickRoom.setName(name);
        sickRoom.setParentId(parentId);
        sickRoom.setStatus(one);
        sickRoom.setIsParent(zero);
        sickRoom.setSortOrder(one);
        sickRoom.setCreated(new Date());
        sickRoom.setUpdated(new Date());
        sickRoomMapper.insert(sickRoom);
        TbSickRoom parentSickRoom = sickRoomMapper.selectByPrimaryKey(parentId);
        if(parentSickRoom.getIsParent() == zero) {
            parentSickRoom.setIsParent(one);
            //更新父节点
            sickRoomMapper.updateByPrimaryKey(parentSickRoom);
        }
        return TaotaoResult.ok();
    }
    @Override
    public TaotaoResult updateBed(BigDecimal id,String name){
        TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(id);
        sickRoom.setName(name);
        sickRoomMapper.updateByPrimaryKey(sickRoom);
        return TaotaoResult.ok();
    }
    @Override
    public TaotaoResult deleteBed(BigDecimal id){
        Short two = 2;
        Short zero = 0;
        boolean canDelete = judgeDeleteBed(id);
        if(canDelete){
            //查询要删除节点自身的实例
            TbSickRoom sickRoom = sickRoomMapper.selectByPrimaryKey(id);
            //找出他的父节点ID
            BigDecimal parentId = sickRoom.getParentId();
            //删除Example，并且删除
            TbSickRoom sickRoom1 = sickRoomMapper.selectByPrimaryKey(id);
            sickRoom1.setStatus(two);
            sickRoomMapper.updateByPrimaryKey(sickRoom1);
            TbSickRoomExample example1 = new TbSickRoomExample();
            TbSickRoomExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andParentIdEqualTo(parentId);
            List<TbSickRoom> list = sickRoomMapper.selectByExample(example1);
            if(list.size() == 0){
                TbSickRoom parentSickRoom = sickRoomMapper.selectByPrimaryKey(parentId);
                parentSickRoom.setIsParent(zero);
                sickRoomMapper.updateByPrimaryKey(parentSickRoom);
            }
            return TaotaoResult.build(200,"删除分类成功");
        }else{
            return TaotaoResult.build(500,"需要清空该分类下所有的分类以及物品才能删除该分类");
        }
    }
    @Override
    public boolean judgeDeleteBed(BigDecimal id){
        Short two = 2;
        Short three = 3;
        TbSickRoomExample example = new TbSickRoomExample();
        TbSickRoomExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<TbSickRoom> sickRoomList = sickRoomMapper.selectByExample(example);
        if(sickRoomList.size() == 0){
            TbMedicalExample example1 = new TbMedicalExample();
            TbMedicalExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andStatusBetween(two,three);
            criteria1.andBedroomEqualTo(id);
            List<TbMedical> medicalList = medicalMapper.selectByExample(example1);
            if(medicalList.size() == 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
