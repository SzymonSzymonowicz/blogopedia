package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Post;
import com.szymonowicz.projekt.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void savePost(Post post){
        postRepository.save(post);
    }



}
