package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.post.PostWithoutComment;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.domain.post.PostForUpdate;

import java.util.List;

public interface PostRepository {
    PostWithoutComment add(PostForCreate postForCreate);

    PostWithoutComment getPostWithoutComment(Long id);

    PostWithoutComment update(PostForUpdate postForUpdate);

    List<PostWithoutComment> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria);

    void delete(Long id);
}
