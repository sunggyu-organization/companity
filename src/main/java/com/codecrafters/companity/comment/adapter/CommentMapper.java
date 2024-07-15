package com.codecrafters.companity.comment.adapter;

import com.codecrafters.companity.comment.adapter.dto.response.ResponseComment;
import com.codecrafters.companity.comment.adapter.infrastructure.jpa.CommentEntity;
import com.codecrafters.companity.comment.domain.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(mappingControl = DeepClone.class, componentModel = MappingConstants.ComponentModel.SPRING)
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
