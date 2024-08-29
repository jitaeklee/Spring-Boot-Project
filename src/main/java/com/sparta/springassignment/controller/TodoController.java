package com.sparta.springassignment.controller;


import com.sparta.springassignment.dto.RequestDto;
import com.sparta.springassignment.dto.ResponseDto;
import com.sparta.springassignment.dto.SingleTodoResponseDto;
import com.sparta.springassignment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/users/{userId}/todos")      // 일정 생성
    public ResponseEntity<ResponseDto> create(@PathVariable Long userId, @RequestBody RequestDto dto) {
        ResponseDto response = todoService.create(userId, dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todos")       // 일정 페이지 조회
    public ResponseEntity<Page<ResponseDto>> getTodos(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ) {
        Page<ResponseDto> response = todoService.getTodos(page, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todos/{todoId}")      // 일정 단건 조회
    public ResponseEntity<SingleTodoResponseDto> getTodo(@PathVariable Long todoId) {
        SingleTodoResponseDto response = todoService.getTodo(todoId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/todos/{todoId}")      // todoId 일정 수정
    public ResponseEntity<ResponseDto> update(@PathVariable Long todoId, @RequestBody RequestDto dto) {
        ResponseDto response = todoService.update(todoId, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/todos/{todoId}")       // todoId 일정 삭제
    public ResponseEntity<ResponseDto> delete(@PathVariable Long todoId) {
    ResponseDto responseDto = todoService.delete(todoId);
        return ResponseEntity.ok(responseDto);
    }


}



