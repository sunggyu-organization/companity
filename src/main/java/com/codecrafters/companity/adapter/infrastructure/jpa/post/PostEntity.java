package com.codecrafters.companity.adapter.infrastructure.jpa.post;

import com.codecrafters.companity.adapter.infrastructure.jpa.comment.CommentEntity;
import com.codecrafters.companity.adapter.infrastructure.jpa.user.UserEntity;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Post")
@Getter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Sport sport;

    @Enumerated(EnumType.STRING)
    private City city;
    private String content;
    private LocalDateTime createAt;
    private boolean recruit;
    private int likeCount;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity owner;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments;
}
