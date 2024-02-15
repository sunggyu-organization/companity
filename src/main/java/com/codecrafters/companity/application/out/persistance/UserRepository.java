package com.codecrafters.companity.application.out.persistance;

import com.codecrafters.companity.domain.user.User;

public interface UserRepository {

    void testQueryDsl();

    User getUserById(Long userId);

    User add(User user);
}
