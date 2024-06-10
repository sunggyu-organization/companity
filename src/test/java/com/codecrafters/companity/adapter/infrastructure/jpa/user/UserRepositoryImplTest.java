package com.codecrafters.companity.adapter.infrastructure.jpa.user;

import com.codecrafters.companity.user.application.port.out.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryImplTest {
    @Autowired
    private UserRepository userRepository;

}