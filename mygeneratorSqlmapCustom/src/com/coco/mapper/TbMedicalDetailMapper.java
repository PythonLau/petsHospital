package com.coco.mapper;

import com.coco.pojo.TbMedicalDetail;
import com.coco.pojo.TbMedicalDetailExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMedicalDetailMapper {
    int countByExample(TbMedicalDetailExample example);

    int deleteByExample(TbMedicalDetailExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbMedicalDetail record);

    int insertSelective(TbMedicalDetail record);

    List<TbMedicalDetail> selectByExampleWithBLOBs(TbMedicalDetailExample example);

    List<TbMedicalDetail> selectByExample(TbMedicalDetailExample example);

    TbMedicalDetail selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbMedicalDetail record, @Param("example") TbMedicalDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") TbMedicalDetail record, @Param("example") TbMedicalDetailExample example);

    int updateByExample(@Param("record") TbMedicalDetail record, @Param("example") TbMedicalDetailExample example);

    int updateByPrimaryKeySelective(TbMedicalDetail record);

    int updateByPrimaryKeyWithBLOBs(TbMedicalDetail record);

    int updateByPrimaryKey(TbMedicalDetail record);
}