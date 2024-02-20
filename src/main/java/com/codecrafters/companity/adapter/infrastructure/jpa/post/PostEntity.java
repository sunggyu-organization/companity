package com.codecrafters.companity.adapter.infrastructure.jpa.post;

import com.codecrafters.companity.adapter.infrastructure.jpa.comment.CommentEntity;
import com.codecrafters.companity.adapter.infrastructure.jpa.user.UserEntity;
import com.codecrafters.companity.domain.enumclass.City;
import com.codecrafters.companity.domain.enumclass.Sport;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Post")
@Getter
@Setter
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
    private UserEntity user;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments = new ArrayList<>();
}
