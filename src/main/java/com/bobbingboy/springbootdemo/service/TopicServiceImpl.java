package com.bobbingboy.springbootdemo.service;

import com.alibaba.fastjson.JSON;
import com.bobbingboy.springbootdemo.domain.Article;
import com.bobbingboy.springbootdemo.domain.ArticleRepository;
import com.bobbingboy.springbootdemo.domain.Topic;
import com.bobbingboy.springbootdemo.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic findTopic(long id) {
        Topic topic = topicRepository.findById(id);
        topic.getArticles();
        System.out.println(JSON.toJSONString(topic, true));
        //因為@ManyToMany 之默認FetchType為LAZY延遲加載，在不為了犧牲效能而將加載形式改為EAGER的前提下，
        // 若是想在載入專題時一併載入文章資訊，需在Session關閉之前進行加載，即Transaction完成之前進行載入。

        return topic;
    }

    @Transactional
    @Override
    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic includeArticle(long topicId, long articleId) {
        Topic topic = topicRepository.findById(topicId);
        Article article = articleRepository.getById(articleId);
        topic.getArticles().add(article);

        return topic;
    }

    @Transactional
    @Override
    public Topic excludeArticle(long topicId, long articleId) {
        Topic topic = topicRepository.findById(topicId);
        Article article = articleRepository.getById(articleId);
        topic.getArticles().remove(article);

        return topic;
    }

    @Transactional
    @Override
    public void deleteTopic(long id) {
        topicRepository.deleteById(id);
    }

    @Override
    public Topic findById(long id) {
        return topicRepository.findById(id);
    }
}
