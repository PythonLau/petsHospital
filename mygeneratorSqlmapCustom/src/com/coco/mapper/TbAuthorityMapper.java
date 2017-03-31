package com.coco.mapper;

import com.coco.pojo.TbAuthority;
import com.coco.pojo.TbAuthorityExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAuthorityMapper {
    int countByExample(TbAuthorityExample example);

    int deleteByExample(TbAuthorityExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbAuthority record);

    int insertSelective(TbAuthority record);

    List<TbAuthority> selectByExample(TbAuthorityExample example);

    TbAuthority selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbAuthority record, @Param("example") TbAuthorityExample example);

    int updateByExample(@Param("record") TbAuthority record, @Param("example") TbAuthorityExample example);

    int updateByPrimaryKeySelective(TbAuthority record);

    int updateByPrimaryKey(TbAuthority record);
}