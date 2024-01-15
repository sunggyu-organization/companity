package com.codecrafters.companity.user.infrastructure;

import com.codecrafters.companity.user.service.port.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryImplTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        userRepository.testQueryDsl();
    }
}