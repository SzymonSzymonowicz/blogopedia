package com.szymonowicz.projekt.controller.web;

import com.szymonowicz.projekt.dto.CommentDTO;
import com.szymonowicz.projekt.dto.PostDTO;
import com.szymonowicz.projekt.enums.PrivacyType;
import com.szymonowicz.projekt.model.Author;
import com.szymonowicz.projekt.model.Post;
import com.szymonowicz.projekt.model.Tag;
import com.szymonowicz.projekt.service.AuthorService;
import com.szymonowicz.projekt.service.AuthoritiesService;
import com.szymonowicz.projekt.service.PostService;
import com.szymonowicz.projekt.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PostController {

    private PostService postService;
    private AuthorService authorService;
    private TagService tagService;

    @Autowired
    public PostController(PostService postService, AuthorService authorService, TagService tagService) {
        this.postService = postService;
        this.authorService = authorService;
        this.tagService = tagService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Post> postsByUserRole = postService.getPostsByUserRole();

        model.addAttribute("posts", postsByUserRole);
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("postDTO", new PostDTO());
        model.addAttribute("commentDTO", new CommentDTO());

        return "home";
    }

    @GetMapping("/order")
    public String orderPost(@RequestParam String orderBy, @RequestParam String direction, Model model){
        //List<Post> allPosts = postService.getAllPostsOrdered(orderBy, direction);
        List<Post> postsByUserRole = postService.getPostsByUserRole();
        List<Post> orderedPosts = postService.orderPosts(postsByUserRole, orderBy, direction);

        model.addAttribute("posts", orderedPosts);
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("postDTO", new PostDTO());
        model.addAttribute("commentDTO", new CommentDTO());

        return "home";
    }

    @PostMapping("/post")
    public String addPost(@Valid @ModelAttribute("postDTO") PostDTO postDTO, Errors errors, Model model){
        Optional<Author> author = authorService.getAuthorById(postDTO.getAuthorId());

        if(!author.isPresent())
            // as authorId is taken from select of all Authors, it should never occur, nevertheless just for being sure
            return "home";

        if(errors.hasErrors()){
            model.addAttribute("posts", postService.getAllPosts());
            model.addAttribute("authors", authorService.getAllAuthors());
            model.addAttribute("commentDTO", new CommentDTO());

            return "home";
        }

        Set<Author> authors = new HashSet<>();
        authors.add(author.get());

        Set<Tag> tagsFromString = tagService.getTagsFromString(postDTO.getTags());
        Post post = new Post();
        post.setPostContent(postDTO.getPostContent());
        post.setPrivacyType(postDTO.getPrivacyType());
        post.setTags(tagsFromString);
        post.setComments(new ArrayList<>());
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

        if(postOptional.isEmpty())
            return "redirect:/";

        Post post = postOptional.get();

        String tagsStr = postService.getTagsAsString(post);

        PostDTO postDTO = new PostDTO();
        postDTO.setPostContent(post.getPostContent());
        postDTO.setTags(tagsStr);

        model.addAttribute("postId", postId);
        model.addAttribute("postDTO", postDTO);
        model.addAttribute("authors", authorService.getAllAuthors());

        return "editPostView";
    }

    @PostMapping("/post/edit/{postId}")
    public String editPost(
            @PathVariable(name = "postId") long postId,
            @ModelAttribute("postDTO") @Valid PostDTO updatedPostDTO,
            Errors errors,
//            @ModelAttribute("post") Post post,
            Model model
            ){

        if(errors.hasErrors()){
            model.addAttribute("postId", postId);
            model.addAttribute("postDTO", updatedPostDTO);
            model.addAttribute("authors", authorService.getAllAuthors());

            return "editPostView";
        }

        Optional<Author> authorOptional = authorService.getAuthorById(updatedPostDTO.getAuthorId());

        if(!authorOptional.isPresent()) {
            System.out.println("There isn't any user of id --> " + updatedPostDTO.getAuthorId() + " <--");
            return "redirect:/";
        }

        Author author = authorOptional.get();

        postService.editPost(author, postId, updatedPostDTO);

        return "redirect:/";
    }

}
