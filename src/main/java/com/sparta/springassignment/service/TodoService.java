package com.sparta.springassignment.service;


import com.sparta.springassignment.dto.RequestDto;
import com.sparta.springassignment.dto.ResponseDto;
import com.sparta.springassignment.entity.Todo;
import com.sparta.springassignment.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public ResponseDto create(RequestDto dto) {
        Todo todo = new Todo(
                dto.getManagerName(),
                dto.getTitle(),
                dto.getContent()
        );
        Todo savedTodo = todoRepository.save(todo);
        return new ResponseDto(
                savedTodo.getId(),
                savedTodo.getManagerName(),
                savedTodo.getTitle(),
                savedTodo.getContent(),
                savedTodo.getCreatedAt(),
                savedTodo.getModifiedAt()
        );
    }


    public ResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("일정 없음"));
        ResponseDto responseDto = new ResponseDto(
                todo.getId(),
                todo.getManagerName(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
        return responseDto;
    }

    public ResponseDto update(Long todoId, RequestDto dto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("일정 없음"));
        todo.update(
                dto.getManagerName(),
                dto.getTitle(),
                dto.getContent()
        );
        todoRepository.save(todo);
        return new ResponseDto(
                todo.getId(),
                todo.getManagerName(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }


    public ResponseDto delete(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElse(null);
        todoRepository.delete(todo);
        return new ResponseDto(
                todo.getId(),
                todo.getManagerName(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }
}







