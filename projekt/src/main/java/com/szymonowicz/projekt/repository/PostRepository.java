package com.szymonowicz.projekt.repository;

import com.szymonowicz.projekt.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
