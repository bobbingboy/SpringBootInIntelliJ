package com.bobbingboy.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.bobbingboy.springbootdemo.domain.Article;
import com.bobbingboy.springbootdemo.domain.Comment;
import com.bobbingboy.springbootdemo.domain.Topic;
import com.bobbingboy.springbootdemo.service.ArticleService;
import com.bobbingboy.springbootdemo.service.TopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TopicTests {

    @Autowired
    private TopicService topicService;

    @Test
    public void saveTopicTest() {
        Topic topic = new Topic();
        topic.setName("政經議題");
        topicService.saveTopic(topic);
    }

    @Test
    public void updateTopicTest() {
        Topic topic = topicService.findTopic(56);
        topic.setName("教育");
        topicService.saveTopic(topic);
    }

    @Test
    public void includeArticleTest() {
        topicService.includeArticle(56, 46);
    }

    @Test
    public void findTopicTest() {
        Topic topic = topicService.findTopic(56);
    }

    @Test
    public void excludeArticleTest() {
        topicService.excludeArticle(56, 46);
    }

    @Test
    public void deleteTopic() {
        topicService.deleteTopic(56);
    }

}
