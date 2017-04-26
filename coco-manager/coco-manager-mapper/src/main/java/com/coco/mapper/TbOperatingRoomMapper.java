package com.coco.mapper;

import com.coco.pojo.TbOperatingRoom;
import com.coco.pojo.TbOperatingRoomExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TbOperatingRoomMapper {
    int countByExample(TbOperatingRoomExample example);

    int deleteByExample(TbOperatingRoomExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbOperatingRoom record);

    int insertSelective(TbOperatingRoom record);

    List<TbOperatingRoom> selectByExample(TbOperatingRoomExample example);

    TbOperatingRoom selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbOperatingRoom record, @Param("example") TbOperatingRoomExample example);

    int updateByExample(@Param("record") TbOperatingRoom record, @Param("example") TbOperatingRoomExample example);

    int updateByPrimaryKeySelective(TbOperatingRoom record);

    int updateByPrimaryKey(TbOperatingRoom record);
}