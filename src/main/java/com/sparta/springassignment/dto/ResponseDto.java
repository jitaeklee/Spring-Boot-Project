package com.sparta.springassignment.dto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseDto {

    private Long id;
    private String managerName;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ResponseDto(      //생성자
            Long id,
            String managerName,
            String title,
            String content,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.managerName = managerName;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }



}
