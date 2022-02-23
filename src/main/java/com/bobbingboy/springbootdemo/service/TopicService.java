package com.bobbingboy.springbootdemo.service;

import com.bobbingboy.springbootdemo.domain.Topic;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TopicService {

    Topic saveTopic(Topic topic);

    Topic findTopic(long id);

    Topic updateTopic(Topic topic);

    Topic includeArticle(long topicId, long articleId);

    @Transactional
    Topic excludeArticle(long topicId, long articleId);

    void deleteTopic(long id);

    Topic findById(long id);


}
