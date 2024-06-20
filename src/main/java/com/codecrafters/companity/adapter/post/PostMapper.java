package com.codecrafters.companity.adapter.post;

import com.codecrafters.companity.adapter.post.dto.request.RequestForCreatingPost;
import com.codecrafters.companity.adapter.post.dto.request.RequestForUpdatingPost;
import com.codecrafters.companity.adapter.post.dto.response.ResponsePost;
import com.codecrafters.companity.adapter.post.infrastructure.jpa.PostEntity;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.PostForUpdate;
import com.codecrafters.companity.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(mappingControl = DeepClone.class)
public interface PostMapper {

    PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "owner", source = "user")
    PostForCreate toDomain(RequestForCreatingPost dto, User user);
    @Mapping(target = "owner", source = "user")
    PostForUpdate toDomain(RequestForUpdatingPost dto, User user);

    Post toDomain(PostEntity entity);
    List<Post> toDomains(List<PostEntity> entities);
    PostEntity toEntity(Post domain);

    @Mapping(source = "sport", target = "sportsNo")
    @Mapping(source = "city", target = "cityNo")
    @Mapping(source = "owner.userName", target = "ownerName")
    ResponsePost toDto(Post post);

    @Mapping(source = "sport", target = "sportsNo")
    @Mapping(source = "city", target = "cityNo")
    @Mapping(source = "owner.userName", target = "ownerName")
    List<ResponsePost> toDtos(List<Post> post);

    default int sportToSportsNo(Sport sport){
        return sport.getNo();
    }

    default int cityToCityNo(City city){
        return city.getNo();
    }
}
