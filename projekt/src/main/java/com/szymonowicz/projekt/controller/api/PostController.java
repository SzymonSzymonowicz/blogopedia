package com.szymonowicz.projekt.controller.api;

import com.szymonowicz.projekt.model.Post;
import com.szymonowicz.projekt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("apiPostController")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/api/post")
    public List<Post> getPosts(){
        return postService.getAllPosts();
    }

    @PostMapping("/api/post")
    public Post addPost(@RequestBody Post post){
        postService.addPost(post);
        return post;
    }

    @GetMapping("/api/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long postId){
        Optional<Post> postFromDb = postService.getPost(postId);

        if(postFromDb.isPresent())
            return new ResponseEntity<Post>(postFromDb.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
