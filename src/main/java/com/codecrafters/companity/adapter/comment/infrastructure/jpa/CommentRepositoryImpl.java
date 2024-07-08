package com.codecrafters.companity.adapter.comment.infrastructure.jpa;

import com.codecrafters.companity.application.out.persistence.CommentRepository;
import com.codecrafters.companity.domain.comment.Comment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import static com.codecrafters.companity.adapter.comment.CommentMapper.COMMENT_MAPPER;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    private final CommentJPARepository commentJPARepository;
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Comment add(Comment comment) {
        CommentEntity savedEntity = commentJPARepository.save(COMMENT_MAPPER.toEntity(comment));
        return COMMENT_MAPPER.toDomain(savedEntity);
    }
}
