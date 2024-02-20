package com.codecrafters.companity.mock.repository;

import com.codecrafters.companity.application.out.persistance.PostRepository;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.OrderType;
import com.codecrafters.companity.domain.post.Post;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostInMemoryImpl implements PostRepository {
    public final Map<Long, Post> repository = new ConcurrentHashMap<>();
    private final AtomicLong keyCreator = new AtomicLong();
    @Override
    public Post add(Post post) {
        post.setId(keyCreator.getAndIncrement());
        repository.put(post.getId(), post);
        return post;
    }

    @Override
    public Post getById(Long id) {
        if(!repository.containsKey(id)) throw new IllegalArgumentException();
        return repository.get(id);
    }

    @Override
    public Post save(Post post) {
        repository.put(post.getId(), post);
        return post;
    }

    @Override
    public List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(Sport sport, City city, boolean recruit, OrderType orderType) {
        return null;
    }
}
