package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.config.mapper.CompanityObjectMapper;
import com.codecrafters.companity.domain.post.PostWithoutComment;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class PostFactory {
    private final CompanityObjectMapper modelMapper;

    public PostWithoutComment create(PostWithoutComment target, User user){
        PostWithoutComment result = modelMapper.copy(target);
//        result.setOwner(user);
//        result.setCreatedAt(localDateTime);
        return result;
    }

    public PostWithoutComment update(PostWithoutComment oldPost, PostWithoutComment newPost) {
        return modelMapper.overwrite(newPost, oldPost);
    }
}
