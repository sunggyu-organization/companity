package com.codecrafters.companity.config.mapper;

import com.codecrafters.companity.adapter.infrastructure.jpa.post.PostEntity;
import com.codecrafters.companity.adapter.post.in.RequestForCreatingPost;
import com.codecrafters.companity.adapter.post.out.ResponsePost;
import com.codecrafters.companity.application.in.post.dto.PostCreateDto;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(mappingControl = DeepClone.class)
public interface PostMapper {
    PostMapper postMapper = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "owner.nickName", ignore = true)
    Post entityToDomain(PostEntity entity);

    @Mapping(target = "comments", ignore = true)
    PostEntity domainToEntity(Post post);

    @Mapping(target = "owner", source = "user")
    @Mapping(target = "recruit", constant = "false")
    @Mapping(target = "likeCount", constant = "0")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Post getPostForCreating(PostCreateDto dto, User user);

    @Mapping(source = "sport", target = "sportsNo")
    @Mapping(source = "city", target = "cityNo")
    ResponsePost toResponsePost(Post post);

    PostCreateDto toPost(RequestForCreatingPost dto);

    default int sportToSportsNo(Sport sport){
        return sport.getNo();
    }

    default int cityToCityNo(City city){
        return city.getNo();
    }
}
