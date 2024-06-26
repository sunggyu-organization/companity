package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepository {
    Post add(Post post);

    Post getById(Long id);

    Post update(Post post);

    Page<Post> findByCriteria(PostCriteria postCriteria, Pageable pageable);

    void delete(Long id);
}
