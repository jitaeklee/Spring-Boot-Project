package com.sparta.springassignment.entity;


import com.sparta.springassignment.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String managerName;
    private String email;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Schedule> scheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Todo> todoList = new ArrayList<>();

    public User(String managerName, String email) {

        this.managerName = managerName;
        this.email = email;
    }

    public static User createUser(UserRequestDto dto, Todo todo) {
        return new User(

                dto.getManagerName(),
                dto.getEmail()
        );
    }


    public void update(String managerName, String email) {
        if (managerName != null) {
            this.managerName = managerName;
        }
        if (email != null) {
            this.email = email;
        }
    }
}


