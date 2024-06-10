package com.codecrafters.companity.application.in.usecase;

import com.codecrafters.companity.adapter.user.dto.request.UserCreateRequest;
import com.codecrafters.companity.domain.user.User;

public interface UserUseCase {
    public User signUp(UserCreateRequest user);
    public User updateNickName(String userId, String nickName);
    public void delete(String userId) throws Exception;
}
