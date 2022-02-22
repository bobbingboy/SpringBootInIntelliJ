package com.bobbingboy.springbootdemo.service;

import com.bobbingboy.springbootdemo.domain.Article;

public interface ArticleService {

    Article saveArticle(Article article);

    Article updateArticle(Article article);

    Article findArticle(long id);

    void deleteArticle(long id);

    Article findById(long id);
}
