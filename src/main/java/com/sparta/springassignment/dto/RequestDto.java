package com.sparta.springassignment.dto;

import com.sparta.springassignment.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestDto {

    private String managerName;
    private String title;
    private String content;

}
