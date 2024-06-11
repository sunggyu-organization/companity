package com.codecrafters.companity.user.application.port.out;

import com.codecrafters.companity.user.domain.User;

public interface UserRepository {
    User save(User user);
    User getUserById(String userId);

    void deleteById(String userId);
}
