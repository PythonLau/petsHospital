package com.coco.mapper;

import com.coco.pojo.TbSickRoom;
import com.coco.pojo.TbSickRoomExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TbSickRoomMapper {
    int countByExample(TbSickRoomExample example);

    int deleteByExample(TbSickRoomExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbSickRoom record);

    int insertSelective(TbSickRoom record);

    List<TbSickRoom> selectByExample(TbSickRoomExample example);

    TbSickRoom selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbSickRoom record, @Param("example") TbSickRoomExample example);

    int updateByExample(@Param("record") TbSickRoom record, @Param("example") TbSickRoomExample example);

    int updateByPrimaryKeySelective(TbSickRoom record);

    int updateByPrimaryKey(TbSickRoom record);
}