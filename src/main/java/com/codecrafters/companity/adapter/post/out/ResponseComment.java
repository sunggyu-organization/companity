package com.codecrafters.companity.adapter.post.out;

import com.codecrafters.companity.adapter.user.ResponseUser;

import java.time.LocalDateTime;

public class ResponseComment {
    private Long id;
    private String content;
    private LocalDateTime date;
    private ResponseUser owner;
}
