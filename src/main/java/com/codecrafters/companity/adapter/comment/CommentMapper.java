package com.codecrafters.companity.adapter.comment;

import com.codecrafters.companity.adapter.comment.dto.response.ResponseComment;
import com.codecrafters.companity.adapter.comment.infrastructure.jpa.CommentEntity;
import com.codecrafters.companity.domain.Comment.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(mappingControl = DeepClone.class)
public interface CommentMapper {
    CommentMapper COMMENT_MAPPER = Mappers.getMapper(CommentMapper.class);
    @Mapping(source = "owner", target = "user")
    CommentEntity toEntity(Comment comment);
    @Mapping(source = "user", target = "owner")
    Comment toDomain(CommentEntity entity);

    @Mapping(source = "user", target = "owner")
    List<Comment> toDomains(List<CommentEntity> entities);

    ResponseComment toDto(Comment result);

    List<ResponseComment> toDtos(List<Comment> content);
}
