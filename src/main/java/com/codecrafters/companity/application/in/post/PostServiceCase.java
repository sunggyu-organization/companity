package com.codecrafters.companity.application.in.post;

import com.codecrafters.companity.domain.post.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostServiceCase {
    Post add(Post post, Long userId);
}
