package com.szymonowicz.projekt.controller.web;

import com.szymonowicz.projekt.dto.PostDTO;
import com.szymonowicz.projekt.model.Author;
import com.szymonowicz.projekt.model.Comment;
import com.szymonowicz.projekt.model.Post;
import com.szymonowicz.projekt.service.AuthorService;
import com.szymonowicz.projekt.service.CommentService;
import com.szymonowicz.projekt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class PostController {

    private PostService postService;
    private CommentService commentService;
    private AuthorService authorService;

    @Autowired
    public PostController(PostService postService, AuthorService authorService, CommentService commentService) {
        this.postService = postService;
        this.authorService = authorService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("posts", postService.getAllPosts());
        model.addAttribute("authors", authorService.getAllAuthors());

        model.addAttribute("postDTO", new PostDTO());
        model.addAttribute("comment", new Comment());

        return "home";
    }

    @PostMapping("/post")
    public String addPost(PostDTO postDTO){
        Optional<Author> author = authorService.getAuthorById(postDTO.getAuthorId());

        if(!author.isPresent())
          // TODO maybe handiling author not found, realistically it will not ever occur, because author is selected from select of authors from database
          return "redirect:/";

        Set<Author> authors = new HashSet<Author>();
        authors.add(author.get());

        Post post = new Post();
        post.setPostContent(postDTO.getPostContent());
        post.setTags(postDTO.getTags());
        post.setComments(new ArrayList<Comment>());
        post.setAuthors(authors);

        postService.addPost(post);

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


    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable(name = "id") long postId){
        postService.deletePost(postId);

        return "redirect:/";
    }

    @GetMapping("/comment/delete/{id}")
    public String deleteComment(@PathVariable(name = "id") long commentId){
        commentService.deleteComment(commentId);

        return "redirect:/";
    }
}
