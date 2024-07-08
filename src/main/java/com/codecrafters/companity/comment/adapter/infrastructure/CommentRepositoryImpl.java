package com.codecrafters.companity.comment.adapter.infrastructure;

import com.codecrafters.companity.comment.application.port.out.persistence.CommentRepository;
import com.codecrafters.companity.comment.adapter.infrastructure.jpa.CommentEntity;
import com.codecrafters.companity.comment.adapter.infrastructure.jpa.CommentJPARepository;
import com.codecrafters.companity.comment.domain.Comment;
import com.codecrafters.companity.domain.post.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import static com.codecrafters.companity.comment.adapter.CommentMapper.COMMENT_MAPPER;
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
        CommentEntity savedEntity = commentJPARepository.save(toEntity(comment));
        return toDomain(savedEntity);
    }

    @Override
    public Comment getById(Long id) {
        CommentEntity entity = commentJPARepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 댓글입니다.");
        });
        return toDomain(entity);
    }

    @Override
    public Comment update(Comment comment) {
        CommentEntity save = commentJPARepository.save(toEntity(comment));
        return toDomain(save);
    }

    private Comment toDomain(CommentEntity entity){
        return COMMENT_MAPPER.toDomain(entity);
    }

    private CommentEntity toEntity(Comment comment){
        return COMMENT_MAPPER.toEntity(comment);
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
