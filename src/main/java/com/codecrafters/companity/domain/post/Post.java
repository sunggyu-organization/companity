package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return Objects.equals(owner, post.getOwner())
                && Objects.equals(id, post.getId())
                && Objects.equals(title, post.getTitle())
                && Objects.equals(city, post.getCity())
                && Objects.equals(sport, post.getSport())
                && Objects.equals(content, post.getContent())
                && Objects.equals(createdAt, post.getCreatedAt())
                && Objects.equals(modifiedAt, post.getModifiedAt())
                && Objects.equals(recruit, post.getRecruit())
                && Objects.equals(likeCount, post.getLikeCount());
    }
}
