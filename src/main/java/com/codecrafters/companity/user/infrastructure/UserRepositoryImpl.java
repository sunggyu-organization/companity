package com.codecrafters.companity.user.infrastructure;

import com.codecrafters.companity.user.service.port.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.codecrafters.companity.user.infrastructure.QUserEntity.userEntity;


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
    public void testQueryDsl() {
        List<UserEntity> result = jpaQueryFactory.selectFrom(userEntity).where(userEntity.name.eq("test")).fetch();
    }
}
