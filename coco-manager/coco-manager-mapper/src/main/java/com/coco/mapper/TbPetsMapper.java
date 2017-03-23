package com.coco.mapper;

import com.coco.pojo.TbPets;
import com.coco.pojo.TbPetsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPetsMapper {
    int countByExample(TbPetsExample example);

    int deleteByExample(TbPetsExample example);

    int insert(TbPets record);

    int insertSelective(TbPets record);

    List<TbPets> selectByExample(TbPetsExample example);

    int updateByExampleSelective(@Param("record") TbPets record, @Param("example") TbPetsExample example);

    int updateByExample(@Param("record") TbPets record, @Param("example") TbPetsExample example);
}