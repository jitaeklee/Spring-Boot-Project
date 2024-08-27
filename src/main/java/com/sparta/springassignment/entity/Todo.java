package com.sparta.springassignment.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Todo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String managerName;
    private String title;
    private String content;
    @OneToMany(mappedBy = "todo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();

    public void addCommentList(Comment comment) {
        this.commentList.add(comment);
        comment.setTodo(this);// 외래 키(연관 관계) 설정
    }


    public void update (String managerName, String title, String content) {
        if (managerName != null) {
            this.managerName = managerName;
        }
        if (title != null) {
            this.title = title;
        }
        if (content != null) {
            this.content = content;
        }
    }
    public Todo(String managerName, String title, String content) {
        this.managerName = managerName;
        this.title = title;
        this.content = content;
    }

}
