package com.codecrafters.companity.post.application;

import com.codecrafters.companity.config.mapper.CompanityObjectMapper;
import com.codecrafters.companity.post.domain.Post;
import com.codecrafters.companity.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Component
public class PostFactory {
    private final CompanityObjectMapper modelMapper;

    public Post create(Post target, User user, LocalDateTime localDateTime){
        Post result = modelMapper.copy(target);
        result.setOwner(user);
        result.setCreatedAt(localDateTime);
        return result;
    }

    public Post update(Post oldPost, Post newPost) {
        return modelMapper.overwrite(newPost, oldPost);
    }
}
