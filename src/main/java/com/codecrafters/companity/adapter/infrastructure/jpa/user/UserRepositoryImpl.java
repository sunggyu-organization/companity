package com.codecrafters.companity.adapter.infrastructure.jpa.user;

import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.config.mapper.UserMapper;
import com.codecrafters.companity.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJPARepository userJPARepository;
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public User getUserById(Long userId){
        //TODO need to describe error message

        UserEntity entity = userJPARepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        });
        return UserMapper.INSTANCE.entityToDomain(entity);
    }

    @Override
    public User add(User user) {
        return null;
    }
}
