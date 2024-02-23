package com.codecrafters.companity.adapter.infrastructure.jpa.user;

import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJPARepository userJPARepository;
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public UserRepositoryImpl(UserJPARepository userJPARepository, EntityManager entityManager){
        jpaQueryFactory = new JPAQueryFactory(entityManager);
        this.userJPARepository = userJPARepository;
    }


    @Override
    public User getUserById(Long userId){
        //TODO need to describe error message
        UserEntity entity = userJPARepository.findById(userId).orElseThrow();
        return UserMapper.toDomain(entity);
    }

    @Override
    public User add(User user) {
        return null;
    }
}
