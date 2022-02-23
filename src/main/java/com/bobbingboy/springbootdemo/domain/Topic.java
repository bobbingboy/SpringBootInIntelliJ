package com.bobbingboy.springbootdemo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name="t_topic_article",
            joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id")
    )
    //默認使用FetchType.LAZY的原因為效能因素，若是在載入時一併載入所有關聯資訊可能使效能降低
    private List<Article> articles = new ArrayList<>();

    public Topic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
