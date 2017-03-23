package com.coco.service.impl;

import com.coco.common.pojo.EUTreeNode;
import com.coco.common.pojo.TaotaoResult;
import com.coco.mapper.TbEmployeeMapper;
import com.coco.mapper.TbPositionCatMapper;
import com.coco.pojo.TbEmployee;
import com.coco.pojo.TbEmployeeExample;
import com.coco.pojo.TbPositionCat;
import com.coco.pojo.TbPositionCatExample;
import com.coco.service.PositionCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
@Service
public class PositionCatServiceImpl implements PositionCatService{
    @Autowired
    private TbPositionCatMapper positionCatMapper;
    @Autowired
    private TbEmployeeMapper employeeMapper;
    public List<EUTreeNode> getCatList(long parentId){
        //创建查询条件
        System.out.println(parentId);
        TbPositionCatExample example = new TbPositionCatExample();
        TbPositionCatExample.Criteria criteria = example.createCriteria();
        BigDecimal parent_Id = new BigDecimal(parentId);
        criteria.andParentIdEqualTo(parent_Id);
        //根据条件查询
        List<TbPositionCat> list = positionCatMapper.selectByExample(example);
        System.out.println("size...");
        System.out.println(list.size());
        List<EUTreeNode> resultList = new ArrayList<>();
        //把列表转换成treeNodelist
        for (TbPositionCat tbPositionCat : list) {
            EUTreeNode node = new EUTreeNode();
            node.setId(tbPositionCat.getId());
            System.out.println("1111111");
            node.setText(tbPositionCat.getName());
            Short status = tbPositionCat.getIsParent();
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
    public TaotaoResult insertPositionCat(long parentId, String name){
        //创建一个pojo
        TbPositionCat tbPositionCat = new TbPositionCat();
        tbPositionCat.setName(name);
        Short isTrue = 1;
        Short isFalse = 0;
        Short sort = 1;
        tbPositionCat.setIsParent(isFalse);
        tbPositionCat.setStatus(isTrue);
        BigDecimal parent_Id = new BigDecimal(parentId);
        tbPositionCat.setParentId(parent_Id);
        tbPositionCat.setSortOrder(sort);
        //添加记录
        positionCatMapper.insert(tbPositionCat);
        //查看父节点的isParent列是否为true，如果不是true改成true
        TbPositionCat parentCat = positionCatMapper.selectByPrimaryKey(parent_Id);
        //判断是否为true
        if(parentCat.getIsParent() == isFalse) {
            parentCat.setIsParent(isTrue);
            //更新父节点
            positionCatMapper.updateByPrimaryKey(parentCat);
        }
        //返回结果
        return TaotaoResult.ok(tbPositionCat);
    }

    @Override
    public TaotaoResult updatePositionCat(long id,String name){
        BigDecimal cat_id = new BigDecimal(id);
        TbPositionCat tbPositionCat = positionCatMapper.selectByPrimaryKey(cat_id);
        tbPositionCat.setName(name);
        positionCatMapper.updateByPrimaryKey(tbPositionCat);
        return TaotaoResult.ok();
    }

    @Override
    public boolean judgeDeletePositionCat(long id){
        //假如他下面没有分类并且没有商品，就返回true,否则返回false,如果还有分类就递归查询。
        TbPositionCatExample judgeCatExample = new TbPositionCatExample();
        TbPositionCatExample.Criteria judgeCatCriteria = judgeCatExample.createCriteria();
        BigDecimal deleteId = new BigDecimal(id);
        judgeCatCriteria.andParentIdEqualTo(deleteId);
        List<TbPositionCat> judgeCatList = positionCatMapper.selectByExample(judgeCatExample);
        if(judgeCatList.size() == 0){
            TbEmployeeExample judgeEmployeeExample = new TbEmployeeExample();
            TbEmployeeExample.Criteria judgeEmployeeCriteria = judgeEmployeeExample.createCriteria();
            judgeEmployeeCriteria.andCidEqualTo(id);
            Short isTrue = 1;
            judgeEmployeeCriteria.andStatusEqualTo(isTrue);
            List<TbEmployee> judgeEmployeeList = employeeMapper.selectByExample(judgeEmployeeExample);
            if(judgeEmployeeList.size() == 0){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public TaotaoResult deletePositionCat(long id){
        //判断该分类是否能删除
        //判断下面是否还存在有分类
        BigDecimal deleteId = new BigDecimal(id);
        boolean canDelete = judgeDeletePositionCat(id);
        if(canDelete){
            //查询要删除节点自身的实例
            TbPositionCat positionCat = positionCatMapper.selectByPrimaryKey(deleteId);
            //找出他的父节点ID
            BigDecimal parentId = positionCat.getParentId();
            //删除Example，并且删除
            TbPositionCatExample deleteExample = new TbPositionCatExample();
            TbPositionCatExample.Criteria criteria2 = deleteExample.createCriteria();
            criteria2.andIdEqualTo(deleteId);
            positionCatMapper.deleteByExample(deleteExample);
            //查询父节点下面的子节点个数
            TbPositionCatExample selectExample = new TbPositionCatExample();
            TbPositionCatExample.Criteria criteria = selectExample.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            List<TbPositionCat> list = positionCatMapper.selectByExample(selectExample);
            if(list.size() == 0){
                TbPositionCat parentCat = positionCatMapper.selectByPrimaryKey(parentId);
                Short isFalse = 0;
                parentCat.setIsParent(isFalse);
                positionCatMapper.updateByPrimaryKey(parentCat);
            }
            return TaotaoResult.build(200,"删除部门成功");
        }else{
            return TaotaoResult.build(500,"该部门下面还存在子部门或在职员工，不能删除");
        }
    }
}
