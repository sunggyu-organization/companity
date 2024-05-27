package com.codecrafters.companity.adapter.infrastructure.jpa.user;

import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.config.mapper.CompanityObjectMapper;
import com.codecrafters.companity.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJPARepository userJPARepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final CompanityObjectMapper mapper;


    @Override
    public User getUserById(Long userId){
        //TODO need to describe error message
        UserEntity entity = userJPARepository.findById(userId).orElseThrow();
        return mapper.convert(entity, User.class);
    }

    @Override
    public User add(User user) {
        return null;
    }
}
