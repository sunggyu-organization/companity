package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enumclass.City;
import com.codecrafters.companity.domain.enumclass.Sport;
import com.codecrafters.companity.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private User user;
    private Long id;
    private String title;
    private City city;
    private Sport sport;
    private String content;
    private LocalDateTime localDateTime;
    private boolean recruit;
    private int likeCount;
    private List<Comment> comments;
}
