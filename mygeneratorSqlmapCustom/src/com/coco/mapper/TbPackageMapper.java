package com.coco.mapper;

import com.coco.pojo.TbPackage;
import com.coco.pojo.TbPackageExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPackageMapper {
    int countByExample(TbPackageExample example);

    int deleteByExample(TbPackageExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbPackage record);

    int insertSelective(TbPackage record);

    List<TbPackage> selectByExample(TbPackageExample example);

    TbPackage selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbPackage record, @Param("example") TbPackageExample example);

    int updateByExample(@Param("record") TbPackage record, @Param("example") TbPackageExample example);

    int updateByPrimaryKeySelective(TbPackage record);

    int updateByPrimaryKey(TbPackage record);
}