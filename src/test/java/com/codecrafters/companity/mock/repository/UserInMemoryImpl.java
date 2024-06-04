package com.codecrafters.companity.mock.repository;

import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.domain.user.User;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserInMemoryImpl implements UserRepository {
    private final Map<String, User> repository = new ConcurrentHashMap<>();
    @Override
    public User save(User user) {
        repository.put(user.getUserId(), user);
        return user;
    }

    @Override
    public User getUserById(String userId) {
        if(!repository.containsKey(userId)) throw new IllegalArgumentException();
        return repository.get(userId);
    }
}
