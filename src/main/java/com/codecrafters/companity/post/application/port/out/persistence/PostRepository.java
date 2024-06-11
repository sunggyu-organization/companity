package com.codecrafters.companity.post.application.port.out.persistence;

import com.codecrafters.companity.post.domain.Post;

import java.util.List;

public interface PostRepository {
    Post add(Post post);

    Post getById(Long id);

    Post save(Post post);

    List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria);
}
