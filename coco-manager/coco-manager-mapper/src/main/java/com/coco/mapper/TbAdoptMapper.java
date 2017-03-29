package com.coco.mapper;

import com.coco.pojo.TbAdopt;
import com.coco.pojo.TbAdoptExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TbAdoptMapper {
    int countByExample(TbAdoptExample example);

    int deleteByExample(TbAdoptExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbAdopt record);

    int insertSelective(TbAdopt record);

    List<TbAdopt> selectByExample(TbAdoptExample example);

    TbAdopt selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbAdopt record, @Param("example") TbAdoptExample example);

    int updateByExample(@Param("record") TbAdopt record, @Param("example") TbAdoptExample example);

    int updateByPrimaryKeySelective(TbAdopt record);

    int updateByPrimaryKey(TbAdopt record);
}