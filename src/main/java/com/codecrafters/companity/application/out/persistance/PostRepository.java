package com.codecrafters.companity.application.out.persistance;

import com.codecrafters.companity.domain.post.Post;

public interface PostRepository {
    Post add(Post post);

    Post getById(Long id);

    Post save(Post post);
}
