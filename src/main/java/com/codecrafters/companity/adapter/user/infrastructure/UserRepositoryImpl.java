package com.codecrafters.companity.adapter.user.infrastructure;

import com.codecrafters.companity.application.out.persistance.user.UserRepository;
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


    //interface를 가져오는 것은 좋은데 너무 귀찮은데?? 기본적인 crud를 다 만들어줘야 되잖아
}
