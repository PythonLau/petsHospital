package com.coco.mapper;

import com.coco.pojo.TbArticle;
import com.coco.pojo.TbArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbArticleMapper {
    int countByExample(TbArticleExample example);

    int deleteByExample(TbArticleExample example);

    int insert(TbArticle record);

    int insertSelective(TbArticle record);

    List<TbArticle> selectByExampleWithBLOBs(TbArticleExample example);

    List<TbArticle> selectByExample(TbArticleExample example);

    int updateByExampleSelective(@Param("record") TbArticle record, @Param("example") TbArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") TbArticle record, @Param("example") TbArticleExample example);

    int updateByExample(@Param("record") TbArticle record, @Param("example") TbArticleExample example);
}