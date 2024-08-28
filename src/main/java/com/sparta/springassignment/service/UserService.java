package com.sparta.springassignment.service;


import com.sparta.springassignment.dto.*;
import com.sparta.springassignment.entity.Comment;
import com.sparta.springassignment.entity.Schedule;
import com.sparta.springassignment.entity.Todo;
import com.sparta.springassignment.entity.User;
import com.sparta.springassignment.repository.ScheduleRepository;
import com.sparta.springassignment.repository.TodoRepository;
import com.sparta.springassignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public UserResponseDto create(UserRequestDto dto) {
        User user = new User(
                dto.getManagerName(),
                dto.getEmail()
        );
        User savedUser = userRepository.save(user);
        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getManagerName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }

    public ScheduleResponseDto adduser(ScheduleRequestDto scheduleRequestDto) {
        Long todoId = scheduleRequestDto.getTodoId();
        Todo todo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("대상 게시물이 없습니다."));
        Long userId = scheduleRequestDto.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("대상 유저가 없습니다."));

        Schedule schedule = new Schedule(todo, user);
        scheduleRepository.save(schedule);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    public List<UserResponseDto> getTodos() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : userList) {
            userResponseDtoList.add(new UserResponseDto(
                            user.getId(),
                            user.getManagerName(),
                            user.getEmail(),
                            user.getCreatedAt(),
                            user.getModifiedAt()));
        }
        return userResponseDtoList;
    }


    public UserResponseDto getuser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("유저 없음"));
        UserResponseDto userResponseDto = new UserResponseDto(
                user.getId(),
                user.getManagerName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
        return userResponseDto;
    }

    public UserResponseDto update(Long userId, UserRequestDto dto) {
    User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("대상 유저가 없습니다."));
    user.update(
            dto.getManagerName(),
            dto.getEmail()
    );
    userRepository.save(user);
    UserResponseDto userResponseDto = new UserResponseDto(
            user.getId(),
            user.getManagerName(),
            user.getEmail(),
            user.getCreatedAt(),
            user.getModifiedAt()
    );
    return userResponseDto;
    }

    public UserResponseDto delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("대상 유저가 없습니다."));
        userRepository.delete(user);
        UserResponseDto userResponseDto = new UserResponseDto(
                user.getId(),
                user.getManagerName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
        return userResponseDto;
    }
}



