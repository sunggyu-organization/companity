package com.codecrafters.companity.comment.adapter.infrastructure.jpa;

import com.codecrafters.companity.adapter.common.infrastructure.jpa.BaseTimeEntity;
import com.codecrafters.companity.adapter.post.infrastructure.jpa.PostEntity;
import com.codecrafters.companity.adapter.user.infrastructure.jpa.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Comment")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
