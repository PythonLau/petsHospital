package com.coco.service.impl;

import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbArticleMapper;
import com.coco.pojo.TbArticle;
import com.coco.pojo.TbArticleExample;
import com.coco.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private TbArticleMapper articleMapper;
    public List<TbArticle> getArticleTitleList(boolean isPaging){
        TbArticleExample example = new TbArticleExample();
        List<TbArticle> list = null;
        if(isPaging){
            example.setOrderByClause("id desc");
            PageHelper.startPage(1, 8);
            list = articleMapper.selectByExample(example);
        }else{
            list = articleMapper.selectByExample(example);
        }
        return list;
    }
    @Override
    public TbArticle getContent(BigDecimal id){
        System.out.println("article service...");
        TbArticleExample example = new TbArticleExample();
        TbArticleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbArticle> article = articleMapper.selectByExampleWithBLOBs(example);
        return article.get(0);
    }
    @Override
    public TaotaoResult createItem(TbArticle article, String typeName) throws Exception{
        Long articleId = IDUtils.genItemId();
        BigDecimal article_id = new BigDecimal(articleId);
        article.setId(article_id);
        article.setTypename(typeName);
        Date date = new Date();
        String time = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
        article.setCreated(time);
        article.setUpdated(time);
        articleMapper.insert(article);
        return TaotaoResult.build(200,"新增成功");
    }
}
