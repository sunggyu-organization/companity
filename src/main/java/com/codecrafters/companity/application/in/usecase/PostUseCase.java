package com.codecrafters.companity.application.in.usecase;

import com.codecrafters.companity.domain.post.Post;

public interface PostUseCase {
    Post add(Post post, Long userId);
    Post update(Long postId, Post post);
}
