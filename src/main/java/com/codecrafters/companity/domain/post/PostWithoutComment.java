package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class PostWithoutComment {
    private User owner;
    private Long id;
    private String title;
    private City city;
    private Sport sport;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean recruit;
    private Integer likeCount;
}