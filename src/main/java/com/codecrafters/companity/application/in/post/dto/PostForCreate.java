package com.codecrafters.companity.application.in.post.dto;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostForCreate {
    private String title;
    private City city;
    private Sport sport;
    private String content;

    public Post toPost(User user){
        return Post.builder()
                .owner(user)
                .title(title)
                .city(city)
                .sport(sport)
                .content(content)
                .recruit(false)
                .likeCount(0)
                .comments(null)
                .build();
    }
}
