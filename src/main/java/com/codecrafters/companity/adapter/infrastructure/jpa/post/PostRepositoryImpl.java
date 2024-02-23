package com.codecrafters.companity.adapter.infrastructure.jpa.post;

import com.codecrafters.companity.application.out.persistance.PostRepository;
import com.codecrafters.companity.application.service.post.PostCriteria;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.OrderType;
import com.codecrafters.companity.domain.post.Post;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.codecrafters.companity.adapter.infrastructure.jpa.post.QPostEntity.postEntity;


@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJPARepository postJPARepository;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Post add(Post post) {
        PostEntity entity = postJPARepository.save(PostMapper.toEntity(post));
        return PostMapper.toDomain(entity);
    }

    @Override
    public Post getById(Long id) {
        return null;
    }

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria) {
        //TODO
//        List<PostEntity> postEntities = jpaQueryFactory.selectFrom(postEntity)
//                .where(eqSport(sport),
//                        eqCity(city),
//                        postEntity.recruit.eq(recruit))
//                .orderBy(getOrderBy(orderType))
//                .fetch();
        return null;
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
        if(orderType == null) return postEntity.createAt.desc();
        switch (orderType){
            case Favorite:
                return postEntity.likeCount.desc();
            case RecentDate:
                return postEntity.createAt.desc();
        }
        return postEntity.createAt.desc();
    }

}
