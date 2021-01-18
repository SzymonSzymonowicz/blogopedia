package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Comment;
import com.szymonowicz.projekt.model.Post;
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
    private final AuthoritiesService authoritiesService;

    public CommentService(CommentRepository commentRepository, AuthoritiesService authoritiesService){
        this.commentRepository = commentRepository;
        this.authoritiesService = authoritiesService;
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
            if(username.equals(comment.getAuthor().getUsername()))
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
        log.info("Changing comment id ---> " + commentFromDb.getId());
        commentRepository.save(commentFromDb);
    }

    public List<Comment> getCommentsForAuthorUsername(String username) {
        List<Comment> comments = commentRepository.findAll();
        List<Comment> result = new ArrayList<>();

        for (Comment comment : comments) {
            if(username.equalsIgnoreCase(comment.getAuthor().getUsername()))
                result.add(comment);
        }

        return result;
    }

    public boolean isMyComment(long commentId){
        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if(commentOptional.isEmpty())
            return false;

        Comment comment = commentOptional.get();
        String username = authoritiesService.getUsername();

        return comment.getAuthor().equals(username);
    }

}
