package com.codecrafters.companity.config.mapper;

import com.codecrafters.companity.adapter.infrastructure.jpa.post.PostEntity;
import com.codecrafters.companity.adapter.post.out.ResponsePost;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(mappingControl = DeepClone.class)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post entityToDomain(PostEntity entity);

    @Mapping(source = "sport", target = "sportsNo")
    @Mapping(source = "city", target = "cityNo")
    ResponsePost serviceToResponsePost(Post post);

    default int sportToSportsNo(Sport sport){
        return sport.getNo();
    }

    default int cityToCityNo(City city){
        return city.getNo();
    }
}
