package com.codecrafters.companity.adapter.post.infrastructure.inmemory;

import com.codecrafters.companity.application.out.persistance.post.PostRepository;
import com.codecrafters.companity.domain.post.Post;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostInMemoryImpl implements PostRepository {
    private final Map<Long, Post> repository = new ConcurrentHashMap<>();
    private final AtomicLong keyCreator = new AtomicLong();
    @Override
    public Post add(Post post) {
        post.setId(keyCreator.getAndIncrement());
        repository.put(post.getId(), post);
        return post;
    }
}
