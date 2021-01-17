package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.dto.PostDTO;
import com.szymonowicz.projekt.model.*;
import com.szymonowicz.projekt.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private TagService tagService;

    public PostService(PostRepository postRepository,TagService tagService){
        this.postRepository = postRepository;
        this.tagService = tagService;
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

    public List<Post> getAllPostsForAuthorId(long authorId){
        List<Post> authorPosts = new ArrayList<Post>();
        List<Post> posts = postRepository.findAll();

        for (Post p : posts) {
            if(p.getAuthors().stream().filter(author -> author.getId() == authorId).count() != 0)
                authorPosts.add(p);
        }

        return authorPosts;
    }

    public void addComment(long postId, Comment comment){
        Optional<Post> postOptional = postRepository.findById(postId);

        if(!postOptional.isPresent()) {
            log.info("Can't add post to post of id = " + postId + ", because it doesn't exists!");
            return;
        }

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

    public void editPost(Author author, long postId, PostDTO updatedPostDTO) {
        Optional<Post> postOptional = postRepository.findById(postId);

        if(!postOptional.isPresent()){
            log.info("Post with id -> " + postId + " <- doesn't exist!");
            return;
        }

        Post postFromDb = postOptional.get();

        // if user who edited the post isn't already in authors list, add him
        if(!postFromDb.getAuthors().contains(author))
            postFromDb.getAuthors().add(author);

        Set<Tag> tagsFromString = tagService.getTagsFromString(updatedPostDTO.getTags());

        postFromDb.setPostContent(updatedPostDTO.getPostContent());
        postFromDb.setTags(tagsFromString);

        postRepository.save(postFromDb);
    }

    public List<Post> getPostsBy(String by, String value) {
        List<Post> allPosts = postRepository.findAll();
        List<Post> result = new ArrayList<>();

        if(by.equals("id")){
            Optional<Post> byId = postRepository.findById(Long.valueOf(value));

            if(byId.isPresent())
                result.add(byId.get());
        }else if(by.equals("tag")){
            for(Post post : allPosts) {
                if(post.getTags().stream().anyMatch(tag -> tag.getTagName().equalsIgnoreCase(value))){
                    result.add(post);
                }
            }
        }else if(by.equals("author")){
            for(Post post: allPosts){
                if(post.getAuthors().stream().anyMatch(author -> author.getUsername().equalsIgnoreCase(value))){
                    result.add(post);
                }
            }
        }else if(by.equals("content")){
            for(Post post: allPosts){
                if(Arrays.stream(post.getPostContent().split("\\W+")).anyMatch(word -> word.equalsIgnoreCase(value))){
                    result.add(post);
                }
            }
        }

        return result;
    }

    public List<Post> getAllPostsOrdered(String orderBy, String direction) {
        List<Post> result = new ArrayList<>();

        if(orderBy.equals("id")){
            if(direction.equals("asc"))
                result = postRepository.findAllByOrderByIdAsc();
            else if(direction.equals("desc"))
                result = postRepository.findAllByOrderByIdDesc();
        }else if(orderBy.equals("content")){
            if(direction.equals("asc"))
                result = postRepository.findAllByOrderByPostContentAsc();
            else if(direction.equals("desc"))
                result = postRepository.findAllByOrderByPostContentDesc();
        }

        return result;
    }

    public void addAttachment(long postId, String filename){
        Optional<Post> postOptional = postRepository.findById(postId);

        if(!postOptional.isPresent()){
            log.info("Post with id -> " + postId + " <- doesn't exist!");
            return;
        }

        Post post = postOptional.get();

        Attachment attachment = new Attachment();
        attachment.setFileName(filename);
        post.getAttachments().add(attachment);

        postRepository.save(post);
    }

    public String getTagsAsString(Post post){
        if(post == null)
            return null;

        String tagsStr = post.getTags().stream()
                .map(tag -> tag.getTagName())
                .reduce((a, b) -> a + " " + b)
                .get();

        return tagsStr;
    }
}
