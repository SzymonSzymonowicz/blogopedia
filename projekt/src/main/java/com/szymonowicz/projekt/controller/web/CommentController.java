package com.szymonowicz.projekt.controller.web;

import com.szymonowicz.projekt.dto.PostDTO;
import com.szymonowicz.projekt.model.Comment;
import com.szymonowicz.projekt.service.AuthorService;
import com.szymonowicz.projekt.service.CommentService;
import com.szymonowicz.projekt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

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
    public String addCommentToPost(@PathVariable(name = "id") long postId, @Valid @ModelAttribute("comment") Comment comment, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("posts", postService.getAllPosts());
            model.addAttribute("authors", authorService.getAllAuthors());
            model.addAttribute("postDTO", new PostDTO());

            return "home";
        }

        Comment saveComment = new Comment();
        saveComment.setUsername(comment.getUsername());
        saveComment.setCommentContent(comment.getCommentContent());

        postService.addComment(postId, saveComment);
        return "redirect:/";
    }

    @GetMapping("/comment/edit/{id}")
    public String editPostView(@PathVariable(name = "id") long commentId, Model model){
        Optional<Comment> commentOptional = commentService.getComment(commentId);

        if(commentOptional.isEmpty())
            return "redirect:/";

        Comment comment = commentOptional.get();

        String oldContent = comment.getCommentContent();

        model.addAttribute("oldContent", oldContent);
        model.addAttribute("comment", comment);

        return "editCommentView";
    }

    @PostMapping("/comment/edit/{id}")
    public String editPost(
            @PathVariable(name = "id") long commentId,
            @ModelAttribute("comment") @Valid Comment editedComment,
            Errors errors,
            @ModelAttribute("oldContent") String oldContent,
            Model model){

        if(errors.hasErrors()){
            model.addAttribute("comment", editedComment);
            model.addAttribute("oldContent", oldContent);

            return "editCommentView";
        }

        commentService.editComment(commentId, editedComment);

        return "redirect:/";
    }


}
