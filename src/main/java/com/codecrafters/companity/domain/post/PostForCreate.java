package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@Builder
public class PostForCreate {
    private String title;
    private City city;
    private Sport sport;
    private String content;

    public Post toPost(User owner){
        validate();
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

    private void validate(){
        if (!StringUtils.hasText(title)) throw new IllegalArgumentException("title is required.");
        if (city == null) throw new IllegalArgumentException("city is required.");
        if (sport == null) throw new IllegalArgumentException("sport is required.");
    }
}
