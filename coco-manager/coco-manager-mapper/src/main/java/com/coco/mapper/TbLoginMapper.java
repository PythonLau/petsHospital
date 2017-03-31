package com.coco.mapper;

import com.coco.pojo.TbLogin;
import com.coco.pojo.TbLoginExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TbLoginMapper {
    int countByExample(TbLoginExample example);

    int deleteByExample(TbLoginExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbLogin record);

    int insertSelective(TbLogin record);

    List<TbLogin> selectByExample(TbLoginExample example);

    TbLogin selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbLogin record, @Param("example") TbLoginExample example);

    int updateByExample(@Param("record") TbLogin record, @Param("example") TbLoginExample example);

    int updateByPrimaryKeySelective(TbLogin record);

    int updateByPrimaryKey(TbLogin record);
}