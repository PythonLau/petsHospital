package com.taotao.mapper;

import com.taotao.pojo.TbPositionCat;
import com.taotao.pojo.TbPositionCatExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPositionCatMapper {
    int countByExample(TbPositionCatExample example);

    int deleteByExample(TbPositionCatExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbPositionCat record);

    int insertSelective(TbPositionCat record);

    List<TbPositionCat> selectByExample(TbPositionCatExample example);

    TbPositionCat selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbPositionCat record, @Param("example") TbPositionCatExample example);

    int updateByExample(@Param("record") TbPositionCat record, @Param("example") TbPositionCatExample example);

    int updateByPrimaryKeySelective(TbPositionCat record);

    int updateByPrimaryKey(TbPositionCat record);
}