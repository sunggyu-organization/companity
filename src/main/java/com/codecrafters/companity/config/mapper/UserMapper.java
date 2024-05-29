package com.codecrafters.companity.config.mapper;

import com.codecrafters.companity.adapter.infrastructure.jpa.user.UserEntity;
import com.codecrafters.companity.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(mappingControl = DeepClone.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "nickName", ignore = true)
    User entityToDomain(UserEntity entity);
}
