package com.coco.mapper;

import com.coco.pojo.TbPets;
import com.coco.pojo.TbPetsExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPetsMapper {
    int countByExample(TbPetsExample example);

    int deleteByExample(TbPetsExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbPets record);

    int insertSelective(TbPets record);

    List<TbPets> selectByExample(TbPetsExample example);

    TbPets selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbPets record, @Param("example") TbPetsExample example);

    int updateByExample(@Param("record") TbPets record, @Param("example") TbPetsExample example);

    int updateByPrimaryKeySelective(TbPets record);

    int updateByPrimaryKey(TbPets record);
}