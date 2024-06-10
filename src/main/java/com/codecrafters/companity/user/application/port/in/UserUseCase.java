package com.codecrafters.companity.user.application.port.in;

import com.codecrafters.companity.user.adapter.dto.request.UserCreateRequest;
import com.codecrafters.companity.user.domain.User;

public interface UserUseCase {
    public User signUp(UserCreateRequest user);
    public User updateNickName(String userId, String nickName);
    public void delete(String userId) throws Exception;
}
