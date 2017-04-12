package com.coco.mapper;

import com.coco.pojo.TbFlow;
import com.coco.pojo.TbFlowExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TbFlowMapper {
    int countByExample(TbFlowExample example);

    int deleteByExample(TbFlowExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbFlow record);

    int insertSelective(TbFlow record);

    List<TbFlow> selectByExample(TbFlowExample example);

    TbFlow selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbFlow record, @Param("example") TbFlowExample example);

    int updateByExample(@Param("record") TbFlow record, @Param("example") TbFlowExample example);

    int updateByPrimaryKeySelective(TbFlow record);

    int updateByPrimaryKey(TbFlow record);
}