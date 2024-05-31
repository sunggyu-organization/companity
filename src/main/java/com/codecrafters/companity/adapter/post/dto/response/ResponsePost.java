package com.codecrafters.companity.adapter.post.dto.response;

import com.codecrafters.companity.adapter.user.ResponseUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class ResponsePost {
    private Long id;
    private String title;
    private int cityNo;
    private int sportsNo;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private boolean recruit;
    private int likeCount;
    private ResponseUser owner;
}
