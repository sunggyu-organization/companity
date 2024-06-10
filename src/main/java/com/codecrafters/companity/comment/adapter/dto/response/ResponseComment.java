package com.codecrafters.companity.comment.adapter.dto.response;

import com.codecrafters.companity.user.adapter.ResponseUser;

import java.time.LocalDateTime;

public class ResponseComment {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private ResponseUser owner;
}
