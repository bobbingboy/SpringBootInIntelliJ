package com.bobbingboy.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.bobbingboy.springbootdemo.domain.Article;
import com.bobbingboy.springbootdemo.domain.Comment;
import com.bobbingboy.springbootdemo.service.ArticleService;
import com.bobbingboy.springbootdemo.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CommentTests {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Test
    public void saveComment() {
        Article article = articleService.findArticle(46);

        Comment comment = new Comment();
        comment.setContent("美中貿易戰影響了全球化市場資源的重新分配");
        comment.setArticle(article);

        commentService.saveComment(comment);
    }

    @Test
    public void deleteComment() {
        commentService.deleteComment(55);
    }


}
