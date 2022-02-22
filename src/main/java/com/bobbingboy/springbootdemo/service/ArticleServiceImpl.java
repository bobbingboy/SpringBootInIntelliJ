package com.bobbingboy.springbootdemo.service;


import com.bobbingboy.springbootdemo.domain.Article;
import com.bobbingboy.springbootdemo.domain.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article findArticle(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public void deleteArticle(long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article findById(long id) {
        return articleRepository.findById(id);
    }
}
