package com.codecrafters.companity.adapter.user.infrastructure;

import com.codecrafters.companity.adapter.user.infrastructure.jpa.UserEntity;
import com.codecrafters.companity.adapter.user.infrastructure.jpa.UserJPARepository;
import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
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
    public User getUserById(String userId) {
        UserEntity userEntity = userJPARepository.getById(userId);
        return userEntity.toDomain();
    }
}
