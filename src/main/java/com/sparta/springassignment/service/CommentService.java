package com.sparta.springassignment.service;


import com.sparta.springassignment.dto.CommentRequestDto;
import com.sparta.springassignment.dto.CommentResponseDto;
import com.sparta.springassignment.entity.Comment;
import com.sparta.springassignment.entity.Todo;
import com.sparta.springassignment.repository.CommentRepository;
import com.sparta.springassignment.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TodoRepository todoRepository;

    public CommentResponseDto create(Long todoId, CommentRequestDto dto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("대상 게시글이 없습니다."));
        Comment comment = Comment.createComment(dto, todo);
        Comment created = commentRepository.save(comment);
        return new CommentResponseDto(
                created.getId(),
                created.getTodo().getId(),
                created.getNickname(),
                created.getBody(),
                created.getCreatedAt(),
                created.getModifiedAt()
        );
    }

    public List<CommentResponseDto> getcomments(Long todoId) {
        return commentRepository.findByArticleId(todoId)
                .stream()
                .map(comment -> CommentResponseDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    public CommentResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("일정 없음"));
        CommentResponseDto commentResponseDto = new CommentResponseDto(
                comment.getId(),
                comment.getTodo().getId(),
                comment.getNickname(),
                comment.getBody(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
        return commentResponseDto;

    }

    public CommentResponseDto update(Long commentId, CommentRequestDto dto) {
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("대상 댓글이 없습니다."));
        target.patch(dto);
        Comment updated = commentRepository.save(target);
        return CommentResponseDto.createCommentDto(updated);
    }

    public CommentResponseDto delete(Long commentId) {
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("대상이 없습니다."));
        commentRepository.delete(target);
        return CommentResponseDto.createCommentDto(target);
    }
}
