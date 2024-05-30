package com.codecrafters.companity.application.in.post;

import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.domain.post.Post;

import java.util.List;

public interface PostUseCase {
    Post add(PostForCreate postForCreate);
    Post update(Long postId, Post post);

    List<Post> findByCriteria(PostCriteria postCriteria);

    Post findDetailById(Long id);
}
