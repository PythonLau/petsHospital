package com.coco.mapper;

import com.coco.pojo.TbModule;
import com.coco.pojo.TbModuleExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbModuleMapper {
    int countByExample(TbModuleExample example);

    int deleteByExample(TbModuleExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbModule record);

    int insertSelective(TbModule record);

    List<TbModule> selectByExample(TbModuleExample example);

    TbModule selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbModule record, @Param("example") TbModuleExample example);

    int updateByExample(@Param("record") TbModule record, @Param("example") TbModuleExample example);

    int updateByPrimaryKeySelective(TbModule record);

    int updateByPrimaryKey(TbModule record);
}