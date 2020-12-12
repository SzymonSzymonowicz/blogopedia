package com.szymonowicz.projekt.repository;

import com.szymonowicz.projekt.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
