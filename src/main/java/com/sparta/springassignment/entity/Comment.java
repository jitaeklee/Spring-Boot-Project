package com.sparta.springassignment.entity;


import com.sparta.springassignment.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "todoids")
    private Todo todo;
    private String nickname;
    private String body;

    public static Comment createComment(CommentRequestDto dto, Todo todo) {
        return new Comment(
                todo,
                dto.getNickname(),
                dto.getBody()
        );
    }

    //생성자
    public Comment(Todo todo, String nickname, String body) {
        this.todo = todo;
        this.nickname = nickname;
        this.body = body;
    }

    public void patch(CommentRequestDto dto) {
        if (dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if (dto.getBody() != null)
            this.body = dto.getBody();
    }
}


