package com.bobbingboy.springbootdemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Topic findById(long id);
}
