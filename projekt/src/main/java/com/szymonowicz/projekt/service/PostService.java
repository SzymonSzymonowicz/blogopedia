package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Post;
import com.szymonowicz.projekt.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void addPost(Post post){
        postRepository.save(post);
    }

    public Optional<Post> getPost(long postId){
        return postRepository.findById(postId);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

}
