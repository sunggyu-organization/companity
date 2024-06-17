package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Post implements Cloneable{
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

    @Override
    public Post clone() {
        try {
            super.clone();
            return Post.builder()
                    .owner(owner.clone())
                    .id(id)
                    .title(title)
                    .city(city)
                    .sport(sport)
                    .content(content)
                    .createdAt(createdAt)
                    .modifiedAt(modifiedAt)
                    .recruit(recruit)
                    .likeCount(likeCount)
                    .build();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
