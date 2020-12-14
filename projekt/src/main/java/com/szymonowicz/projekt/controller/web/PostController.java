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
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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
    public String addPost(@Valid @ModelAttribute("postDTO") PostDTO postDTO, Errors errors, Model model){
        Optional<Author> author = authorService.getAuthorById(postDTO.getAuthorId());

        if(!author.isPresent())
          // TODO maybe handiling author not found, realistically it will not ever occur, because author is selected from select of authors from database
          return "home";

        if(errors.hasErrors()){
            //System.out.println(errors);
            model.addAttribute("posts", postService.getAllPosts());
            model.addAttribute("authors", authorService.getAllAuthors());
            model.addAttribute("comment", new Comment());

            return "home";
        }

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

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable(name = "id") long postId){
        postService.deletePost(postId);

        return "redirect:/";
    }

    @GetMapping("/post/edit/{postId}")
    public String editPostView(@PathVariable(name = "postId") long postId, Model model){
        Optional<Post> postOptional = postService.getPost(postId);

        if(!postOptional.isPresent())
            return "redirect:/";

        Post post = postOptional.get();

        PostDTO postDTO = new PostDTO();
        postDTO.setPostContent(post.getPostContent());
        postDTO.setTags(post.getTags());

        model.addAttribute("post", post);
        model.addAttribute("postDTO", postDTO);
        model.addAttribute("authors", authorService.getAllAuthors());

        return "editPostView";
    }

    @PostMapping("/post/edit/{postId}")
    public String editPost(@PathVariable(name = "postId") long postId, PostDTO updatedPostDTO){
        Optional<Author> authorOptional = authorService.getAuthorById(updatedPostDTO.getAuthorId());

        if(!authorOptional.isPresent()) {
            System.out.println("There isn't any user of id --> " + updatedPostDTO.getAuthorId() + " <--");
        }
        Author author = authorOptional.get();

        postService.editPost(author, postId, updatedPostDTO);

        return "redirect:/";
    }

}
