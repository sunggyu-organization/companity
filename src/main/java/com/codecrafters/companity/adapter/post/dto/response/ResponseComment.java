package com.codecrafters.companity.adapter.post.dto.response;

import com.codecrafters.companity.adapter.user.ResponseUser;

import java.time.LocalDateTime;

public class ResponseComment {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private ResponseUser owner;
}
