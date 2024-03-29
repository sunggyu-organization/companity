package com.codecrafters.companity.adapter.infrastructure.jpa.comment;

import com.codecrafters.companity.adapter.infrastructure.jpa.post.PostEntity;
import com.codecrafters.companity.adapter.infrastructure.jpa.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Comment")
@Getter
@Setter
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    private String content;
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="post_id")
    private PostEntity post;
}
