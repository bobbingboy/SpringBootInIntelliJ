package com.bobbingboy.springbootdemo.service;

import com.bobbingboy.springbootdemo.domain.Comment;

public interface CommentService {

    Comment saveComment(Comment comment);

    void deleteComment(long id);
}
