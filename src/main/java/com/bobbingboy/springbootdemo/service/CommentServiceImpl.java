package com.bobbingboy.springbootdemo.service;

import com.bobbingboy.springbootdemo.domain.Comment;
import com.bobbingboy.springbootdemo.domain.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void deleteComment(long id) {
        Comment comment = commentRepository.findById(id);
        comment.clearComment();
//        List<Comment> comments = comment.getArticle().getComments();
//        for (Comment comment1 : comments) {
//            if (id == comment.getId()) {
//                comments.remove(comment1);
//                break;
//            }
//        }

//        commentRepository.deleteById(id);
        commentRepository.deleteBy(id);
    }
}
