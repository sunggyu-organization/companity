package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@Builder
public class PostForUpdate {
    private User owner;
    private Long id;
    private String title;
    private City city;
    private Sport sport;
    private String content;

    public Post toPost(Post post){
        validate(post.getOwner());
        return Post.builder()
                .id(id)
                .title(title)
                .sport(sport)
                .city(city)
                .content(content)
                .recruit(post.getRecruit())
                .likeCount(post.getLikeCount())
                .owner(owner.clone())
                .build();
    }

    private void validate(User owner){
        if (id == null) throw new IllegalArgumentException("id is required.");
        if (!StringUtils.hasText(title)) throw new IllegalArgumentException("title is required.");
        if (city == null) throw new IllegalArgumentException("city is required.");
        if (sport == null) throw new IllegalArgumentException("sport is required.");
        if (this.owner == null || owner == null) throw new IllegalArgumentException("writer can only modify.");
        if (!this.owner.getUserId().equals(owner.getUserId())){
            throw new IllegalArgumentException("writer can only modify.");
        }
    }
}
