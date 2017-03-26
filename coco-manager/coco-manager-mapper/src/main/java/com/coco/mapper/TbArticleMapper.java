package com.coco.mapper;

import com.coco.pojo.TbArticle;
import com.coco.pojo.TbArticleExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TbArticleMapper {
    int countByExample(TbArticleExample example);

    int deleteByExample(TbArticleExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TbArticle record);

    int insertSelective(TbArticle record);

    List<TbArticle> selectByExampleWithBLOBs(TbArticleExample example);

    List<TbArticle> selectByExample(TbArticleExample example);

    TbArticle selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TbArticle record, @Param("example") TbArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") TbArticle record, @Param("example") TbArticleExample example);

    int updateByExample(@Param("record") TbArticle record, @Param("example") TbArticleExample example);

    int updateByPrimaryKeySelective(TbArticle record);

    int updateByPrimaryKeyWithBLOBs(TbArticle record);

    int updateByPrimaryKey(TbArticle record);
}