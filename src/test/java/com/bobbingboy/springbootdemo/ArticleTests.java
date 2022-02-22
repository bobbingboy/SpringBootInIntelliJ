package com.bobbingboy.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.bobbingboy.springbootdemo.domain.*;
import com.bobbingboy.springbootdemo.service.ArticleService;
import com.bobbingboy.springbootdemo.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class ArticleTests {

    @Autowired
   private ArticleService articleService;

    @Test
    public void saveArticle() {
        Article article = new Article();
        article.setTitle("關於烏俄衝突");
        article.setContent("是長久以來未解決的歷史問題");

        Comment comment1 = new Comment("評論1");
        Comment comment2 = new Comment("評論2");

        article.addComment(comment1);
        article.addComment(comment2);

        articleService.saveArticle(article);
    }

    @Test
    public void updateArticle() {
        Article article = articleService.findArticle(49);
        article.setContent("並非一朝一夕導致的結果");

        articleService.saveArticle(article);
    }

    @Test
    public void findArticle() {
        Article article = articleService.findArticle(46);
        System.out.println(JSON.toJSONString(article, true));
    }

    @Test
    public void deleteArticle() {
        articleService.deleteArticle(43);
    }
}
