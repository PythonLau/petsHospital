package com.taotao.mapper;

import com.taotao.pojo.TbPosition;
import com.taotao.pojo.TbPositionExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPositionMapper {
    int countByExample(TbPositionExample example);

    int deleteByExample(TbPositionExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbPosition record);

    int insertSelective(TbPosition record);

    List<TbPosition> selectByExample(TbPositionExample example);

    TbPosition selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbPosition record, @Param("example") TbPositionExample example);

    int updateByExample(@Param("record") TbPosition record, @Param("example") TbPositionExample example);

    int updateByPrimaryKeySelective(TbPosition record);

    int updateByPrimaryKey(TbPosition record);
}