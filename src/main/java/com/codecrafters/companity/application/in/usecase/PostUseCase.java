package com.codecrafters.companity.application.in.usecase;

import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.domain.post.Post;

import java.util.List;

public interface PostUseCase {
    Post add(Post post, Long userId);
    Post update(Long postId, Post post);

    List<Post> findByCriteria(PostCriteria postCriteria);

    Post findById(Long id);
}
