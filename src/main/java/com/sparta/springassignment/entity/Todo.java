package com.sparta.springassignment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
