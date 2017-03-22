package com.coco.service.impl;

import com.coco.common.pojo.EUTreeNode;
import com.coco.mapper.TbPositionCatMapper;
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
    public List<EUTreeNode> getCatList(long parentId){
        //创建查询条件
        System.out.println("service....");
        System.out.println("1111");
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
            node.setId(tbPositionCat.getId().longValue());
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
}
