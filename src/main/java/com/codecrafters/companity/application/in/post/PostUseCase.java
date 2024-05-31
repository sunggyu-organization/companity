package com.codecrafters.companity.application.in.post;

import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.domain.post.PostWithoutComment;
import com.codecrafters.companity.domain.post.PostForUpdate;

import java.util.List;

public interface PostUseCase {
    PostWithoutComment add(PostForCreate postForCreate);
    PostWithoutComment update(PostForUpdate postForUpdate);

    List<PostWithoutComment> findByCriteria(PostCriteria postCriteria);

    PostWithoutComment findDetailById(Long id);
}
