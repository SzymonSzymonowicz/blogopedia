package com.szymonowicz.projekt.controller.web;

import com.szymonowicz.projekt.model.Author;
import com.szymonowicz.projekt.service.AuthorService;
import com.szymonowicz.projekt.service.CommentService;
import com.szymonowicz.projekt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class StatisticsController {

    private PostService postService;
    private CommentService commentService;
    private AuthorService authorService;

    @Autowired
    public StatisticsController(PostService postService, AuthorService authorService, CommentService commentService) {
        this.postService = postService;
        this.authorService = authorService;
        this.commentService = commentService;
    }

    @GetMapping("/stats")
    public String statistics(@RequestParam(name = "id") long authorId, Model model){
        Optional<Author> authorOptional = authorService.getAuthorById(authorId);

        if(!authorOptional.isPresent())
            // as authorId is taken from select of all Authors, it should never occur, nevertheless just for being sure
            return "redirect:/";

        Author author = authorOptional.get();

        int postsAdded = postService.countPostsForAuthorId(authorId);
        int commentsAdded = commentService.countCommentsForAuthorUsername(author.getUsername());

        model.addAttribute("author", author);
        model.addAttribute("postsAdded", postsAdded);
        model.addAttribute("commentsAdded", commentsAdded);

        return "statistics";
    }
}
