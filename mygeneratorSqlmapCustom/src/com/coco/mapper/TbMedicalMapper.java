package com.coco.mapper;

import com.coco.pojo.TbMedical;
import com.coco.pojo.TbMedicalExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMedicalMapper {
    int countByExample(TbMedicalExample example);

    int deleteByExample(TbMedicalExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbMedical record);

    int insertSelective(TbMedical record);

    List<TbMedical> selectByExample(TbMedicalExample example);

    TbMedical selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbMedical record, @Param("example") TbMedicalExample example);

    int updateByExample(@Param("record") TbMedical record, @Param("example") TbMedicalExample example);

    int updateByPrimaryKeySelective(TbMedical record);

    int updateByPrimaryKey(TbMedical record);
}