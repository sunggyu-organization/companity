package com.codecrafters.companity.application.in.post;

import com.codecrafters.companity.domain.post.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostUserCase {
    Post add(Post post, Long userId);
    Post update(Long postId, Post post);
}
