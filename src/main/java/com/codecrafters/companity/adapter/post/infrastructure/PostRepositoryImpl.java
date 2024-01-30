package com.codecrafters.companity.adapter.post.infrastructure;

import com.codecrafters.companity.application.out.persistance.post.PostRepository;
import com.codecrafters.companity.domain.post.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
}
