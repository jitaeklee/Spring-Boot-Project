package com.sparta.springassignment.controller;


import com.sparta.springassignment.dto.*;
import com.sparta.springassignment.entity.User;
import com.sparta.springassignment.service.TodoService;
import com.sparta.springassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")      // 유저 생성
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto) {
        UserResponseDto response = userService.create(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/users/todos")      // 유저 추가 배치
    public ResponseEntity<ScheduleResponseDto> addUser(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        ScheduleResponseDto response = userService.adduser(scheduleRequestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")      // 유저 전체 조회
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<UserResponseDto> response = userService.getTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{userId}")      // userId 유저 조회
    public ResponseEntity<UserResponseDto> getuser(@PathVariable Long userId) {
        UserResponseDto response = userService.getuser(userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{userId}")      // userId 유저 수정
    public ResponseEntity<UserResponseDto> update(@PathVariable Long userId, @RequestBody UserRequestDto dto) {
        UserResponseDto response = userService.update(userId, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/users/{userId}")       // userId 유저 삭제
    public ResponseEntity<UserResponseDto> delete(@PathVariable Long userId) {
        UserResponseDto responseDto = userService.delete(userId);
        return ResponseEntity.ok(responseDto);
    }




}
