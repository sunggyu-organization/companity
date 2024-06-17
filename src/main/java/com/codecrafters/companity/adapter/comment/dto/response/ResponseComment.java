package com.codecrafters.companity.adapter.comment.dto.response;

import com.codecrafters.companity.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ResponseComment {
    private Long id;
    private User owner;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
