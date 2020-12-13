package com.szymonowicz.projekt.controller.web;

import com.szymonowicz.projekt.model.Comment;
import com.szymonowicz.projekt.service.AuthorService;
import com.szymonowicz.projekt.service.CommentService;
import com.szymonowicz.projekt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    private PostService postService;
    private CommentService commentService;
    private AuthorService authorService;

    @Autowired
    public CommentController(PostService postService, AuthorService authorService, CommentService commentService) {
        this.postService = postService;
        this.authorService = authorService;
        this.commentService = commentService;
    }

    @GetMapping("/comment/delete/{id}")
    public String deleteComment(@PathVariable(name = "id") long commentId){
        commentService.deleteComment(commentId);

        return "redirect:/";
    }

    @PostMapping("/comment/{id}")
    public String addCommentToPost(@PathVariable(name = "id") long postId, Comment comment){
        Comment saveComment = new Comment();
        saveComment.setUsername(comment.getUsername());
        saveComment.setCommentContent(comment.getCommentContent());

        postService.addComment(postId, saveComment);
        return "redirect:/";
    }

}
