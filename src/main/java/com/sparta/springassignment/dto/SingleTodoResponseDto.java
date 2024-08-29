package com.sparta.springassignment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SingleTodoResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String managerName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}










