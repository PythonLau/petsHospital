package com.coco.mapper;

import com.coco.pojo.TbSlider;
import com.coco.pojo.TbSliderExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSliderMapper {
    int countByExample(TbSliderExample example);

    int deleteByExample(TbSliderExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbSlider record);

    int insertSelective(TbSlider record);

    List<TbSlider> selectByExample(TbSliderExample example);

    TbSlider selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbSlider record, @Param("example") TbSliderExample example);

    int updateByExample(@Param("record") TbSlider record, @Param("example") TbSliderExample example);

    int updateByPrimaryKeySelective(TbSlider record);

    int updateByPrimaryKey(TbSlider record);
}