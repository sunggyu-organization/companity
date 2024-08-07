package com.codecrafters.companity.adapter.post.infrastructure.jpa;

import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.*;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.codecrafters.companity.adapter.post.infrastructure.jpa.QPostEntity.postEntity;
import static com.codecrafters.companity.adapter.post.PostMapper.POST_MAPPER;


@Repository
@Slf4j
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJPARepository postJPARepository;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Post add(Post post) {
        PostEntity save = postJPARepository.save(POST_MAPPER.toEntity(post));
        return POST_MAPPER.toDomain(save);
    }

    @Override
    public Post getById(Long id) {
        PostEntity entity = postJPARepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
        });
        return POST_MAPPER.toDomain(entity);
    }

    @Override
    public void delete(Long id) {
        PostEntity postEntity = postJPARepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
        });
        postJPARepository.delete(postEntity);
    }

    @Override
    public Post update(Post post) {
        PostEntity entity = postJPARepository.findById(post.getId()).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
        });
        entity.update(post);
        postJPARepository.save(entity);
        return POST_MAPPER.toDomain(entity);
    }

    @Override
    public Page<Post> findByCriteria(PostCriteria postCriteria, Pageable pageable) {
        JPAQuery<PostEntity> basicQuery = jpaQueryFactory
                .selectFrom(postEntity)
                .where(likeTitle(postCriteria.getTitle()),
                        likeContent(postCriteria.getContent()),
                        eqSport(postCriteria.getSport()),
                        eqCity(postCriteria.getCity()),
                        eqRecruit(postCriteria.getRecruit()))
                .orderBy(getOrderBy(postCriteria.getOrderType()));

        List<PostEntity> postEntities = basicQuery.clone()
                .leftJoin(postEntity.owner)
                .fetchJoin()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        //FIXME need to change deprecated method
        return PageableExecutionUtils.getPage(POST_MAPPER.toDomains(postEntities), pageable, basicQuery::fetchCount);
    }

    private BooleanExpression likeTitle(String title){
        if(!StringUtils.hasText(title)) return null;
        return postEntity.title.contains(title);
    }

    private BooleanExpression likeContent(String content){
        if(!StringUtils.hasText(content)) return null;
        return postEntity.content.contains(content);
    }

    private BooleanExpression eqSport(Sport sport){
        if(sport == null) return null;
        return postEntity.sport.eq(sport);
    }

    private BooleanExpression eqCity(City city){
        if(city == null) return null;
        return postEntity.city.eq(city);
    }

    private BooleanExpression eqRecruit(Boolean recruit){
        if(recruit == null) return null;
        return postEntity.recruit.eq(recruit);
    }

    private OrderSpecifier getOrderBy(OrderType orderType){
        if(orderType == null) return postEntity.createdAt.desc();
        return switch (orderType) {
            case Favorite -> postEntity.likeCount.desc();
            case RecentDate -> postEntity.createdAt.desc();
        };
    }

}
