package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.user.User;

public interface UserRepository {
    User save(User user);
    User getUserById(String userId);

    void deleteById(String userId);
}
