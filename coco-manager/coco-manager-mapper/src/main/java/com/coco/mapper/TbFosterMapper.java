package com.coco.mapper;

import com.coco.pojo.TbFoster;
import com.coco.pojo.TbFosterExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TbFosterMapper {
    int countByExample(TbFosterExample example);

    int deleteByExample(TbFosterExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbFoster record);

    int insertSelective(TbFoster record);

    List<TbFoster> selectByExample(TbFosterExample example);

    TbFoster selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbFoster record, @Param("example") TbFosterExample example);

    int updateByExample(@Param("record") TbFoster record, @Param("example") TbFosterExample example);

    int updateByPrimaryKeySelective(TbFoster record);

    int updateByPrimaryKey(TbFoster record);
}