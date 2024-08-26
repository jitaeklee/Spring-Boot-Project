package com.sparta.springassignment.controller;


import com.sparta.springassignment.dto.RequestDto;
import com.sparta.springassignment.dto.ResponseDto;
import com.sparta.springassignment.entity.Todo;
import com.sparta.springassignment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/todos")
    public ResponseDto create(@RequestBody RequestDto dto) {
        return todoService.create(dto);
    }
    @GetMapping("/todos/{todoId}")
    public Todo getTodo(@PathVariable Long todoId) {
        return todoService.getTodo(todoId);
    }
    @PutMapping("/todos/{todoId}")
    public ResponseDto update(@PathVariable Long todoId, @RequestBody RequestDto dto) {
        return todoService.update(todoId, dto);
    }


}
