package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Comment;
import com.szymonowicz.projekt.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }

    public Optional<Comment> getComment(long commentId){
        return commentRepository.findById(commentId);
    }

    public void deleteComment(long commentId){
        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if(!commentOptional.isPresent()) {
            log.info("Can't delete comment of id = " + commentId + ", because it doesn't exists!");
            return;
        }

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

    public void editComment(long commentId, Comment updatedComment) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if(!commentOptional.isPresent()){
            log.info("Post with id -> " + commentId + " <- doesn't exist!");
            return;
        }

        Comment commentFromDb = commentOptional.get();

        commentFromDb.setCommentContent(updatedComment.getCommentContent());

        commentRepository.save(commentFromDb);
    }

    public List<Comment> getCommentsForAuthorUsername(String username) {
        List<Comment> comments = commentRepository.findAll();
        List<Comment> result = new ArrayList<>();

        for (Comment comment : comments) {
            if(username.equalsIgnoreCase(comment.getUsername()))
                result.add(comment);
        }

        return result;
    }
}
