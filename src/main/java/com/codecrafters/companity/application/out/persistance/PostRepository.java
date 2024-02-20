package com.codecrafters.companity.application.out.persistance;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.OrderType;
import com.codecrafters.companity.domain.post.Post;

import java.util.List;

public interface PostRepository {
    Post add(Post post);

    Post getById(Long id);

    Post save(Post post);

    List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(Sport sport, City city, boolean recruit, OrderType orderType);
}
