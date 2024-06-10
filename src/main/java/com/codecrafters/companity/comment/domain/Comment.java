package com.codecrafters.companity.comment.domain;

import com.codecrafters.companity.user.domain.User;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private String content;
    private LocalDateTime localDateTime;
    private User user;
}
