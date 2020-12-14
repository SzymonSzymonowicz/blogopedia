package com.szymonowicz.projekt.repository;

import com.szymonowicz.projekt.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByIdAsc();
    List<Post> findAllByOrderByIdDesc();
    List<Post> findAllByOrderByPostContentAsc();
    List<Post> findAllByOrderByPostContentDesc();
}
