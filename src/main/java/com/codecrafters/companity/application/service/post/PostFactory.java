package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.out.utility.CustomModelMapper;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Component
public class PostFactory {
    private final CustomModelMapper modelMapper;

    public Post create(Post target, User user, LocalDateTime localDateTime){
        Post result = modelMapper.copy(target);
        result.setUser(user);
        result.setLocalDateTime(localDateTime);
        return result;
    }

    public Post update(Post oldPost, Post newPost) {
        return modelMapper.overwrite(newPost, oldPost);
    }
}
