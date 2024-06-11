package com.codecrafters.companity.post.domain;

import com.codecrafters.companity.comment.domain.Comment;
import com.codecrafters.companity.post.domain.enums.City;
import com.codecrafters.companity.post.domain.enums.Sport;
import com.codecrafters.companity.user.domain.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
