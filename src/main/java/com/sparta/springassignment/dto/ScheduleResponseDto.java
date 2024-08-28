package com.sparta.springassignment.dto;


import com.sparta.springassignment.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ScheduleResponseDto {

    private Long todoId;
    private Long userId;

    public ScheduleResponseDto(Schedule schedule) {
        this.todoId = schedule.getTodo().getId();
        this.userId = schedule.getUser().getId();
    }
}




