package com.codecrafters.companity.application.out.persistance.post;

import com.codecrafters.companity.domain.post.Post;

public interface PostRepository {
    Post add(Post post);
}
