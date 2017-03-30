package com.coco.mapper;

import com.coco.pojo.TbDoctor;
import com.coco.pojo.TbDoctorExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TbDoctorMapper {
    int countByExample(TbDoctorExample example);

    int deleteByExample(TbDoctorExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbDoctor record);

    int insertSelective(TbDoctor record);

    List<TbDoctor> selectByExample(TbDoctorExample example);

    TbDoctor selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbDoctor record, @Param("example") TbDoctorExample example);

    int updateByExample(@Param("record") TbDoctor record, @Param("example") TbDoctorExample example);

    int updateByPrimaryKeySelective(TbDoctor record);

    int updateByPrimaryKey(TbDoctor record);
}