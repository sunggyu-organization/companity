package com.codecrafters.companity.adapter.dto;

import java.time.LocalDateTime;

public class ResponseComment {
    private Long id;
    private String content;
    private LocalDateTime date;
    private ResponseUser owner;
}
