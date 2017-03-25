package com.coco.controller;

import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbArticle;
import com.coco.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/article/{id}")
    public String getContent(@PathVariable String id, Model model){
        System.out.println("article controller...");
        BigDecimal articleId = new BigDecimal(id);
        TbArticle tbArticle = articleService.getContent(articleId);
        model.addAttribute("article",tbArticle);
        return "article";
    }
    @RequestMapping(value="/manager/article/save",method= RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createArticle(TbArticle article) throws Exception{
        System.out.println("111111111111111");
        TaotaoResult result = articleService.createItem(article,"管理员");
        return result;
    }
    @RequestMapping(value="/articleMore")
    public String showIndex(Model model) {
        boolean isPaging = false;
        List<TbArticle> list = articleService.getArticleTitleList(isPaging);
        model.addAttribute("list",list);
        return "articleMore";
    }
}
