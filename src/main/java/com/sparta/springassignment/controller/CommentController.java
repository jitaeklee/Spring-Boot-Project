package com.sparta.springassignment.controller;


import com.sparta.springassignment.dto.CommentRequestDto;
import com.sparta.springassignment.dto.CommentResponseDto;
import com.sparta.springassignment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")     // todoId 할일에 댓글 추가
    public ResponseEntity<CommentResponseDto> create(@PathVariable Long todoId, @RequestBody CommentRequestDto dto) {
        CommentResponseDto createdDto = commentService.create(todoId, dto);
        return ResponseEntity.ok(createdDto);
    }

    @GetMapping("/todos/comments/{commentId}")     // 댓글 단건 조회
    public ResponseEntity<CommentResponseDto> comment(@PathVariable Long commentId) {
        CommentResponseDto response = commentService.getComment(commentId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todos/{todoId}/comments")     // todoId 할일 댓글 전체조회
    public ResponseEntity<List<CommentResponseDto>> comments(@PathVariable Long todoId) {
        List<CommentResponseDto> dtos = commentService.getcomments(todoId);
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/todos/comments/{commentId}")    // commentId 댓글 수정
    public ResponseEntity<CommentResponseDto> update
            (@PathVariable Long commentId, @RequestBody CommentRequestDto dto) {
        CommentResponseDto updatedDto = commentService.update(commentId, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/todos/comments/{commentId}")   // commentId 댓글 삭제
    public ResponseEntity<CommentResponseDto> delete(@PathVariable Long commentId) {
        CommentResponseDto deletedDto = commentService.delete(commentId);
        return ResponseEntity.ok(deletedDto);
    }


}

