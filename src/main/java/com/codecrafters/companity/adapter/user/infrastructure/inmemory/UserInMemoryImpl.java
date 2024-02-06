package com.codecrafters.companity.adapter.user.infrastructure.inmemory;

import com.codecrafters.companity.application.out.persistance.user.UserRepository;
import com.codecrafters.companity.domain.user.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserInMemoryImpl implements UserRepository {
    private Map<Long, User> repository = new ConcurrentHashMap<>();
    private AtomicLong keyCreator = new AtomicLong();
    @Override
    public User add(User user) {
        user.setId(keyCreator.getAndIncrement());
        repository.put(user.getId(), user);
        return user;
    }

    @Override
    public void testQueryDsl() {

    }

    @Override
    public User getUserById(Long userId) {
        if(!repository.containsKey(userId)) throw new IllegalArgumentException();
        return repository.get(userId);
    }
}
