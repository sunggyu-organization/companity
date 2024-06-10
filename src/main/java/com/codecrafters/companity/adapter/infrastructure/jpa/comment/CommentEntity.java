package com.codecrafters.companity.adapter.infrastructure.jpa.comment;

import com.codecrafters.companity.adapter.infrastructure.jpa.common.BaseTimeEntity;
import com.codecrafters.companity.adapter.infrastructure.jpa.post.PostEntity;
import com.codecrafters.companity.user.adapter.infrastructure.jpa.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Comment")
@Getter
@Setter
public class CommentEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private PostEntity post;
}
