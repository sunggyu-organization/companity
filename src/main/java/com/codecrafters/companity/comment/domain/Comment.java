package com.codecrafters.companity.comment.domain;

import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Comment {
    private Long id;
    private User owner;
    private Post post;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
