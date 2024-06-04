package com.codecrafters.companity.application.in.usecase;

import com.codecrafters.companity.adapter.user.dto.request.UserCreateRequest;
import com.codecrafters.companity.domain.user.User;

public interface UserUseCase {
    public User signUp(UserCreateRequest request);
    public User updateNickName(String userId, String nickName);
}
