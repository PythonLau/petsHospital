package com.coco.service;

import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbArticle;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
public interface ArticleService {
    List<TbArticle> getArticleTitleList();
    TbArticle getContent(BigDecimal id);
    TaotaoResult createItem(TbArticle article,String typeName) throws Exception;
}
