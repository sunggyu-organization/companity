package com.codecrafters.companity.mock.repository;

import com.codecrafters.companity.adapter.utility.dto.response.ResultCode;
import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.domain.user.User;
import com.codecrafters.companity.exception.CustomException;
import org.springframework.http.HttpStatus;

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
        if(!repository.containsKey(userId))
            throw new CustomException(HttpStatus.BAD_REQUEST, ResultCode.USER_NOT_FOUND, "user not found. userId : " + userId);
        return repository.get(userId);
    }

    @Override
    public void deleteById(String userId) {
        repository.remove(userId);
    }
}
