package com.szymonowicz.projekt.controller.web;

import com.szymonowicz.projekt.model.Author;
import com.szymonowicz.projekt.model.Comment;
import com.szymonowicz.projekt.model.Post;
import com.szymonowicz.projekt.service.AuthorService;
import com.szymonowicz.projekt.service.CommentService;
import com.szymonowicz.projekt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    private PostService postService;
    private CommentService commentService;
    private AuthorService authorService;

    @Autowired
    public SearchController(PostService postService, AuthorService authorService, CommentService commentService) {
        this.postService = postService;
        this.authorService = authorService;
        this.commentService = commentService;
    }

    @GetMapping("/search/post")
    public String searchPost(@RequestParam(name = "by") String by, @RequestParam(name = "value") String value, Model model){
        List<Post> posts = postService.getPostsBy(by, value);

        if(posts.isEmpty())
            return "notFound";

        List<Author> authors = authorService.getAllAuthors();

        model.addAttribute("posts", posts);
        model.addAttribute("comment", new Comment());
        model.addAttribute("authors", authors);

        model.addAttribute("by", by);
        model.addAttribute("value", value);

        return "searchPost";
    }

    @GetMapping("/search/user")
    public String searchUser(@RequestParam(name = "for") String forSelect, @RequestParam(name = "username") String username, Model model){
        System.out.println("Selected search -> " + forSelect);
        if(forSelect.equals("posts")){
            return searchPost("author", username, model);
        }
        else if(forSelect.equals("comments")){
            List<Comment> comments = commentService.getCommentsForAuthorUsername(username);

            if(comments.isEmpty())
                return "notFound";

            model.addAttribute("username", username);
            model.addAttribute("comments", comments);

            return "searchComment";
        }
        else
            return "notFound";

    }
}
