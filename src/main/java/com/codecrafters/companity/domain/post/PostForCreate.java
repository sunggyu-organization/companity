package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
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

    public Post toPost(User owner){
        return Post.builder()
                .title(title)
                .sport(sport)
                .city(city)
                .content(content)
                .recruit(false)
                .likeCount(0)
                .owner(owner.clone())
                .build();
    }
}
