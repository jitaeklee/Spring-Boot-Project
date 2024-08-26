package com.sparta.springassignment.repository;


import com.sparta.springassignment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM comment WHERE todo_id = :todoId", nativeQuery = true)
    List<Comment> findByArticleId(Long todoId);
}


