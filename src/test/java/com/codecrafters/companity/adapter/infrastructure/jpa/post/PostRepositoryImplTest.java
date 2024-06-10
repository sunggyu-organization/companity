package com.codecrafters.companity.adapter.infrastructure.jpa.post;

import com.codecrafters.companity.config.mapper.CustomModelMapper;
import com.codecrafters.companity.post.adapter.infrastructure.jpa.PostJPARepository;
import com.codecrafters.companity.post.adapter.infrastructure.PostRepositoryImpl;
import com.codecrafters.companity.post.application.port.out.persistence.PostCriteria;
import com.codecrafters.companity.config.QuerydslConfig;
import com.codecrafters.companity.post.domain.enums.City;
import com.codecrafters.companity.post.domain.enums.Sport;
import com.codecrafters.companity.post.domain.enums.OrderType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({QuerydslConfig.class})
class PostRepositoryImplTest {
    private final PostRepositoryImpl postRepository;

    @Autowired
    PostRepositoryImplTest(PostJPARepository postJPARepository, JPAQueryFactory jpaQueryFactory){
        CustomModelMapper customModelMapper = new CustomModelMapper();
        postRepository = new PostRepositoryImpl(postJPARepository, jpaQueryFactory, customModelMapper);
    }

    @Test
    void findBySportAndCityAndRecruitOrderByRecentDateOrFavorite() {
        PostCriteria postCriteria = PostCriteria.builder().sport(Sport.Badminton).city(City.Seoul).recruit(false).orderType(OrderType.Favorite).build();
        postRepository.findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(postCriteria);
    }
}