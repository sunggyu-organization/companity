package com.codecrafters.companity.post.application.port.in;

import com.codecrafters.companity.post.application.port.out.persistence.PostCriteria;
import com.codecrafters.companity.post.domain.Post;

import java.util.List;

public interface PostUseCase {
    Post add(Post post, String userId);
    Post update(Long postId, Post post);

    List<Post> findByCriteria(PostCriteria postCriteria);

    Post findById(Long id);
}
