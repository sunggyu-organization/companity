package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Post {
    private User owner;
    private Long id;
    private String title;
    private City city;
    private Sport sport;
    private String content;
    private LocalDateTime createdAt;
    private Boolean recruit;
    private Integer likeCount;
    private List<Comment> comments;
}
