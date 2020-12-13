package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Comment;
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

    public void addComment(long postId, Comment comment){
        Optional<Post> postOptional = postRepository.findById(postId);

        if(!postOptional.isPresent())
            return;

        Post post = postOptional.get();
        List<Comment> postComments = post.getComments();
        postComments.add(comment);

        postRepository.save(post);
    }

    public void deletePost(long postId){
        Optional<Post> postOptional = postRepository.findById(postId);

        if(!postOptional.isPresent())
            return;

        postRepository.deleteById(postOptional.get().getId());
    }

    public int countPostsForAuthorId(long authorId) {
        List<Post> posts = postRepository.findAll();
        int sum = 0;

        for (Post post : posts) {
            sum += post.getAuthors().stream().filter(author -> author.getId() == authorId).count();
        }

        return sum;
    }
}
