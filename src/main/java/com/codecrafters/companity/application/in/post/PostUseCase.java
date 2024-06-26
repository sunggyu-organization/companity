package com.codecrafters.companity.application.in.post;

import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.domain.post.PostForDelete;
import com.codecrafters.companity.domain.post.PostForUpdate;

public interface PostUseCase {
    Post add(PostForCreate postForCreate);

    Post update(PostForUpdate postForUpdate);

    void delete(PostForDelete postForDelete);

    Post get(Long postId);
}
