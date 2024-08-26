package com.sparta.springassignment.dto;


import com.sparta.springassignment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentResponseDto {

    private Long id;
    private Long todoId;
    private String nickname;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static CommentResponseDto createCommentDto(Comment comment) {
        return new CommentResponseDto(
                comment.getId(),
                comment.getTodo().getId(),
                comment.getNickname(),
                comment.getBody(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
    }

}

