package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Comment;
import com.szymonowicz.projekt.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }

    public void deleteComment(long commentId){
        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if(!commentOptional.isPresent())
            return;

        commentRepository.deleteById(commentOptional.get().getId());
    }

    public int countCommentsForAuthorUsername(String username) {
        List<Comment> comments = commentRepository.findAll();
        int sum = 0;

        for (Comment comment : comments) {
            if(username.equals(comment.getUsername()))
                sum++;
        }

        return sum;
    }
}
