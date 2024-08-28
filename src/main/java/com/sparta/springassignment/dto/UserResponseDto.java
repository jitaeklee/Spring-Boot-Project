package com.sparta.springassignment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDto {

    private Long id;
    private String managerName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
