package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepository {
    Post add(Post post);

    Post getPost(Long id);

    Post update(PostForUpdate postForUpdate);

    Page<Post> findByCriteria(PostCriteria postCriteria, Pageable pageable);

    void delete(Long id);
}
