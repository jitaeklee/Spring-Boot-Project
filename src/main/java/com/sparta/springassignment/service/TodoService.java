package com.sparta.springassignment.service;


import com.sparta.springassignment.dto.RequestDto;
import com.sparta.springassignment.dto.ResponseDto;
import com.sparta.springassignment.entity.Schedule;
import com.sparta.springassignment.entity.Todo;
import com.sparta.springassignment.entity.User;
import com.sparta.springassignment.repository.ScheduleRepository;
import com.sparta.springassignment.repository.TodoRepository;
import com.sparta.springassignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ResponseDto create(Long userId, RequestDto dto) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("대상 유저가 없습니다."));
        Todo todo = Todo.createTodo(dto, user);
        Todo savedTodo = todoRepository.save(todo);

        Schedule schedule = new Schedule();
        schedule.setUser(user); // 외래 키(연관 관계) 설정
        schedule.setTodo(todo); // 외래 키(연관 관계) 설정
        scheduleRepository.save(schedule);

        return new ResponseDto(
                savedTodo.getId(),
                savedTodo.getUser().getId(),
                savedTodo.getTitle(),
                savedTodo.getContent(),
                savedTodo.getCreatedAt(),
                savedTodo.getModifiedAt()
        );
    }


    public ResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("대상 일정이 없습니다."));
        ResponseDto responseDto = new ResponseDto(
                todo.getId(),
                todo.getUser().getId(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
        return responseDto;
    }

    public ResponseDto update(Long todoId, RequestDto dto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("대상 일정이 없습니다."));
        todo.update(
                dto.getTitle(),
                dto.getContent()
        );
        todoRepository.save(todo);
        return new ResponseDto(
                todo.getId(),
                todo.getUser().getId(),
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
                todo.getUser().getId(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }

    public Page<ResponseDto> getTodos(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo -> new ResponseDto(
                todo.getId(),
                todo.getUser().getId(),
                todo.getTitle(),
                todo.getContent()
        ));
    }
}







