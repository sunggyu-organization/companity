package com.codecrafters.companity.application.out.persistance.user;

import com.codecrafters.companity.domain.user.User;

public interface UserRepository {

    void testQueryDsl();

    User getUserById(Long userId);

    User add(User user);

    User getUserByUsername(String username);
}
