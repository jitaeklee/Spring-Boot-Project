package com.sparta.springassignment.entity;


import com.sparta.springassignment.dto.RequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "todo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "todo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Schedule> scheduleList = new ArrayList<>();

    public static Todo createTodo(RequestDto dto, User user) {
        return new Todo(
                user,
                dto.getTitle(),
                dto.getContent()
        );
    }

    public void update (String title, String content) {
        if (title != null) {
            this.title = title;
        }
        if (content != null) {
            this.content = content;
        }
    }

    public Todo(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

}


