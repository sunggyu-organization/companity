package com.codecrafters.companity.adapter.post.controller;

import com.codecrafters.companity.adapter.user.controller.ResponseUser;

import java.time.LocalDateTime;

public class ResponseComment {
    private Long id;
    private String content;
    private LocalDateTime date;
    private ResponseUser owner;
}
