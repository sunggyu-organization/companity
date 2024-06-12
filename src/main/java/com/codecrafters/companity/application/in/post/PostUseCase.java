package com.codecrafters.companity.application.in.post;

import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.domain.post.PostForUpdate;
import com.codecrafters.companity.domain.user.User;

public interface PostUseCase {
    Post add(PostForCreate postForCreate, User user);

    Post update(PostForUpdate postForUpdate);
}
