package com.codecrafters.companity.application.service.user;

import com.codecrafters.companity.adapter.user.dto.request.UserCreateRequest;
import com.codecrafters.companity.application.in.usecase.UserUseCase;
import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepository userRepository;

    @Override
    public User signUp(UserCreateRequest request) {
        User user = User.from(request);
        user.validateUser();
        return userRepository.save(user);
    }

}