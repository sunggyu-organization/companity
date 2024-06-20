package com.codecrafters.companity.adapter.comment.infrastructure.jpa;

import com.codecrafters.companity.application.out.persistence.CommentRepository;
import com.codecrafters.companity.domain.Comment.Comment;
import com.codecrafters.companity.domain.post.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import static com.codecrafters.companity.adapter.comment.CommentMapper.COMMENT_MAPPER;
import static com.codecrafters.companity.adapter.post.PostMapper.POST_MAPPER;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    private final CommentJPARepository commentJPARepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final String CREATED_AT = "createdAt";
    @Override
    public Comment add(Comment comment) {
        CommentEntity savedEntity = commentJPARepository.save(COMMENT_MAPPER.toEntity(comment));
        return COMMENT_MAPPER.toDomain(savedEntity);
    }

    @Override
    public Page<Comment> findAllByPost(Post post, Pageable pageable) {
        Page<CommentEntity> allByPost = commentJPARepository.findAllByPost(POST_MAPPER.toEntity(post), applySortByCreatedAt(pageable));
        return new PageImpl<>(COMMENT_MAPPER.toDomains(allByPost.getContent()), pageable, allByPost.getTotalElements());
    }

    private Pageable applySortByCreatedAt(Pageable pageable) {
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.desc(CREATED_AT)));
    }
}
