package com.codecrafters.companity.user.application;

import com.codecrafters.companity.user.adapter.dto.request.UserCreateRequest;
import com.codecrafters.companity.user.application.port.in.UserUseCase;
import com.codecrafters.companity.user.application.port.out.UserRepository;
import com.codecrafters.companity.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepository userRepository;

    @Override
    public User signUp(UserCreateRequest request) {
        User user = User.from(request);
        user.validateCreateUser();

        return userRepository.save(user);
    }

    @Override
    public User updateNickName(String userId, String nickName) {
        User user = userRepository.getUserById(userId);
        user.updateNickName(nickName);

        return userRepository.save(user);
    }

    @Override
    public void delete(String userId) {
        User user = userRepository.getUserById(userId);
        if (user == null) throw new IllegalArgumentException("user not found with UserID : " + userId);

        userRepository.deleteById(userId);
    }

}
