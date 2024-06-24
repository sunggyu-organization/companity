package com.codecrafters.companity.adapter.infrastructure.jpa.post;

import com.codecrafters.companity.adapter.post.infrastructure.jpa.PostJPARepository;
import com.codecrafters.companity.adapter.post.infrastructure.jpa.PostRepositoryImpl;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.config.QuerydslConfig;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.OrderType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({QuerydslConfig.class})
class PostRepositoryImplTest {
    private final PostRepositoryImpl postRepository;

    @Autowired
    PostRepositoryImplTest(PostJPARepository postJPARepository, JPAQueryFactory jpaQueryFactory){
        postRepository = new PostRepositoryImpl(postJPARepository, jpaQueryFactory);
    }

    @Test
    void findByCriteria() {
        PostCriteria postCriteria = PostCriteria.builder().withSport(Sport.Badminton).withCity(City.Seoul).withRecruit(false).withOrderType(OrderType.Favorite).build();
        postRepository.findByCriteria(postCriteria, Pageable.ofSize(10));
    }
}