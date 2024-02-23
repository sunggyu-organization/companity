package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.post.Post;

import java.util.List;

public interface PostRepository {
    Post add(Post post);

    Post getById(Long id);

    Post save(Post post);

    List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria);
}
