package com.codecrafters.companity.application.out.persistance;

import com.codecrafters.companity.application.service.post.PostCriteria;
import com.codecrafters.companity.domain.post.Post;

import java.util.List;

public interface PostRepository {
    Post add(Post post);

    Post getById(Long id);

    Post save(Post post);

    List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria);
}
