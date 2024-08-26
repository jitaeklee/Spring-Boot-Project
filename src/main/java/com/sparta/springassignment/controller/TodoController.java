package com.sparta.springassignment.controller;


import com.sparta.springassignment.dto.RequestDto;
import com.sparta.springassignment.dto.ResponseDto;
import com.sparta.springassignment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<ResponseDto> create(@RequestBody RequestDto dto) {
        ResponseDto response = todoService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<ResponseDto> getTodo(@PathVariable Long todoId) {
        ResponseDto response = todoService.getTodo(todoId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<ResponseDto> update(@PathVariable Long todoId, @RequestBody RequestDto dto) {
        ResponseDto response = todoService.update(todoId, dto);
        return ResponseEntity.ok(response);
    }


}



