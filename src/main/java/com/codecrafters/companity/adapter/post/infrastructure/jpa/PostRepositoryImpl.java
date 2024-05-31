package com.codecrafters.companity.adapter.post.infrastructure.jpa;

import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.config.mapper.CompanityObjectMapper;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.OrderType;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForUpdate;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.codecrafters.companity.adapter.post.infrastructure.jpa.QPostEntity.postEntity;
import static com.codecrafters.companity.adapter.post.mapper.PostMapperForController.POST_MAPPER_FOR_CONTROLLER;


@Repository
@Slf4j
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJPARepository postJPARepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final CompanityObjectMapper mapper;

    @Override
    public Post add(Post post) {
        PostEntity entity = postJPARepository.save(POST_MAPPER_FOR_CONTROLLER.domainToEntity(post));
        return POST_MAPPER_FOR_CONTROLLER.entityToDomain(entity);
    }

    @Override
    public Post getById(Long id) {
        PostEntity entity = postJPARepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
        });
        return POST_MAPPER_FOR_CONTROLLER.entityToDomain(entity);
    }

    @Override
    public Post update(PostForUpdate postForUpdate) {
        PostEntity entity = postJPARepository.findById(postForUpdate.getId()).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
        });
        entity.update(postForUpdate);
        postJPARepository.save(entity);
        return entity.toDomain();
    }

    @Override
    public List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria) {
        List<PostEntity> postEntities = jpaQueryFactory.selectFrom(postEntity)
                .where(eqSport(postCriteria.getSport()),
                        eqCity(postCriteria.getCity()),
                        postEntity.recruit.eq(postCriteria.isRecruit()))
                .orderBy(getOrderBy(postCriteria.getOrderType()))
                .fetch();
        return mapper.convertList(postEntities, Post.class);
    }

    private BooleanExpression eqSport(Sport sport){
        if(sport == null) return null;
        return postEntity.sport.eq(sport);
    }

    private BooleanExpression eqCity(City city){
        if(city == null) return null;
        return postEntity.city.eq(city);
    }

    private OrderSpecifier getOrderBy(OrderType orderType){
        if(orderType == null) return postEntity.createdAt.desc();
        return switch (orderType) {
            case Favorite -> postEntity.likeCount.desc();
            case RecentDate -> postEntity.createdAt.desc();
        };
    }

}
