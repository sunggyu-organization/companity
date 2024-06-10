package com.codecrafters.companity.mock.repository;

import com.codecrafters.companity.post.application.port.out.persistence.PostRepository;
import com.codecrafters.companity.post.application.port.out.persistence.PostCriteria;
import com.codecrafters.companity.post.domain.Post;

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
    public List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria) {
        return null;
    }
}
