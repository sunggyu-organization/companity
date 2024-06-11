package com.codecrafters.companity.post.adapter.infrastructure;

import com.codecrafters.companity.post.adapter.infrastructure.jpa.PostEntity;
import com.codecrafters.companity.post.adapter.infrastructure.jpa.PostJPARepository;
import com.codecrafters.companity.post.application.port.out.persistence.PostRepository;
import com.codecrafters.companity.post.application.port.out.persistence.PostCriteria;
import com.codecrafters.companity.config.mapper.CompanityObjectMapper;
import com.codecrafters.companity.post.domain.enums.City;
import com.codecrafters.companity.post.domain.enums.Sport;
import com.codecrafters.companity.post.domain.enums.OrderType;
import com.codecrafters.companity.post.domain.Post;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.codecrafters.companity.post.adapter.infrastructure.jpa.QPostEntity.postEntity;


@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJPARepository postJPARepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final CompanityObjectMapper mapper;

    @Override
    public Post add(Post post) {
        PostEntity entity = postJPARepository.save(mapper.convert(post, PostEntity.class));
        return mapper.convert(entity, Post.class);
    }

    @Override
    public Post getById(Long id) {
        PostEntity entity = postJPARepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
        });
        return mapper.convert(entity, Post.class);
    }

    @Override
    public Post save(Post post) {
        return null;
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
