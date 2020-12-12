package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Comment;
import com.szymonowicz.projekt.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }



}
