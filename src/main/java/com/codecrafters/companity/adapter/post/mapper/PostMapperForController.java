package com.codecrafters.companity.adapter.post.mapper;

import com.codecrafters.companity.adapter.post.dto.request.RequestForCreatingPost;
import com.codecrafters.companity.adapter.post.dto.response.ResponsePost;
import com.codecrafters.companity.adapter.post.infrastructure.jpa.PostEntity;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(mappingControl = DeepClone.class)
public interface PostMapperForController {
    PostMapperForController POST_MAPPER_FOR_CONTROLLER = Mappers.getMapper(PostMapperForController.class);

    PostForCreate toPost(RequestForCreatingPost dto);

    @Mapping(target = "comments", ignore = true)
    Post entityToDomain(PostEntity entity);

    @Mapping(target = "comments", ignore = true)
    PostEntity domainToEntity(Post post);

    @Mapping(source = "sport", target = "sportsNo")
    @Mapping(source = "city", target = "cityNo")
    ResponsePost toResponsePost(Post post);

    default int sportToSportsNo(Sport sport){
        return sport.getNo();
    }

    default int cityToCityNo(City city){
        return city.getNo();
    }
}
