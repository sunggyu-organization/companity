package com.codecrafters.companity.adapter.post.mapper;

import com.codecrafters.companity.adapter.post.dto.request.RequestForCreatingPost;
import com.codecrafters.companity.adapter.post.dto.request.RequestForUpdatingPost;
import com.codecrafters.companity.adapter.post.dto.response.ResponsePost;
import com.codecrafters.companity.adapter.post.infrastructure.jpa.PostEntity;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.PostWithoutComment;
import com.codecrafters.companity.domain.post.PostForUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(mappingControl = DeepClone.class)
public interface PostMapperForController {
    PostMapperForController POST_MAPPER = Mappers.getMapper(PostMapperForController.class);

    PostForCreate toPostForCreate(RequestForCreatingPost dto);
    PostForUpdate toPostForUpdate(RequestForUpdatingPost dto);

    PostWithoutComment entityToDomain(PostEntity entity);
    PostEntity domainToEntity(Post domain);

    @Mapping(source = "sport", target = "sportsNo")
    @Mapping(source = "city", target = "cityNo")
    ResponsePost toResponsePost(PostWithoutComment post);

    default int sportToSportsNo(Sport sport){
        return sport.getNo();
    }

    default int cityToCityNo(City city){
        return city.getNo();
    }
}
