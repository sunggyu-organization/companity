package com.codecrafters.companity.user.adapter.infrastructure;

import com.codecrafters.companity.user.adapter.infrastructure.jpa.UserEntity;
import com.codecrafters.companity.user.adapter.infrastructure.jpa.UserJPARepository;
import com.codecrafters.companity.adapter.utility.dto.response.ResultCode;
import com.codecrafters.companity.user.application.port.out.UserRepository;
import com.codecrafters.companity.user.domain.User;
import com.codecrafters.companity.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJPARepository userJPARepository;

    @Override
    public User save(User user) {
        UserEntity entity = UserEntity.from(user);
        userJPARepository.save(entity);

        return User.builder()
                .userId(entity.getUserId())
                .userName(entity.getUserName())
                .nickName(entity.getNickName())
                .build();
    }

    @Override
    public User getUserById(String userId){
        UserEntity userEntity = userJPARepository.findById(userId).orElseThrow(() -> {
            throw new CustomException(HttpStatus.BAD_REQUEST, ResultCode.USER_NOT_FOUND, "user not found. userId : " + userId);
        });

        return userEntity.toDomain();
    }

    @Override
    public void deleteById(String userId) {
        userJPARepository.deleteById(userId);
    }
}
