package com.coco.mapper;

import com.coco.pojo.TbEmployee;
import com.coco.pojo.TbEmployeeExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEmployeeMapper {
    int countByExample(TbEmployeeExample example);

    int deleteByExample(TbEmployeeExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbEmployee record);

    int insertSelective(TbEmployee record);

    List<TbEmployee> selectByExample(TbEmployeeExample example);

    TbEmployee selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbEmployee record, @Param("example") TbEmployeeExample example);

    int updateByExample(@Param("record") TbEmployee record, @Param("example") TbEmployeeExample example);

    int updateByPrimaryKeySelective(TbEmployee record);

    int updateByPrimaryKey(TbEmployee record);
}