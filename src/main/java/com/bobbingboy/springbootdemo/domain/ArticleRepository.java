package com.bobbingboy.springbootdemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findById(long id);

    void deleteById(long id);
}
