package com.codecrafters.companity.application.in.post;

import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.domain.post.PostForDelete;
import com.codecrafters.companity.domain.post.PostForUpdate;
import com.codecrafters.companity.domain.user.User;

import java.util.List;

public interface PostUseCase {
    Post add(PostForCreate postForCreate, User user);

    Post update(PostForUpdate postForUpdate);

    void delete(PostForDelete postForDelete);
    List<Post> findByCriteria(PostCriteria postCriteria);
}
