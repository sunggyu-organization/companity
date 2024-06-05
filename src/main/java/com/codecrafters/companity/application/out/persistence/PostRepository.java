package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForUpdate;

import java.util.List;

public interface PostRepository {
    Post add(Post post);

    Post getPost(Long id);

    Post update(PostForUpdate postForUpdate);

    List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria);

    void delete(Long id);
}
