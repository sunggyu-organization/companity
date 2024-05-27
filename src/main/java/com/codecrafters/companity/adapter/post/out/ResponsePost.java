package com.codecrafters.companity.adapter.post.out;

import com.codecrafters.companity.adapter.user.ResponseUser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ResponsePost {
    private Long id;
    private String title;
    private int city;
    private int sportsTypes;
    private String content;
    private LocalDateTime createdAt;
    private boolean recruit;
    private int likeCount;
    private ResponseUser owner;
}
