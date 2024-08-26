package com.sparta.springassignment.service;


import com.sparta.springassignment.dto.RequestDto;
import com.sparta.springassignment.dto.ResponseDto;
import com.sparta.springassignment.entity.Todo;
import com.sparta.springassignment.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public Todo getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("일정 없음"));
        return todo;
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
}
