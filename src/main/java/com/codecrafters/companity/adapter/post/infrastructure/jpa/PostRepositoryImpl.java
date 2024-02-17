package com.codecrafters.companity.adapter.post.infrastructure.jpa;

import com.codecrafters.companity.application.out.persistance.PostRepository;
import com.codecrafters.companity.domain.enumclass.City;
import com.codecrafters.companity.domain.enumclass.Sport;
import com.codecrafters.companity.domain.post.OrderType;
import com.codecrafters.companity.domain.post.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PostRepositoryImpl implements PostRepository {
    private final PostJPARepository postJPARepository;
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public PostRepositoryImpl(PostJPARepository postJPARepository, EntityManager entityManager){
        jpaQueryFactory = new JPAQueryFactory(entityManager);
        this.postJPARepository = postJPARepository;
    }

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
    public List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(Sport sport, City city, boolean recruit, OrderType orderType) {
        return null;
    }
}
