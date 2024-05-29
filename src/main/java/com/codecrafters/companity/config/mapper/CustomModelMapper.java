package com.codecrafters.companity.config.mapper;

import com.codecrafters.companity.adapter.post.dto.response.ResponsePost;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.Post;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomModelMapper implements CompanityObjectMapper {
    private final ModelMapper modelMapper;
    public CustomModelMapper(){
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setDeepCopyEnabled(true);
        modelMapper.typeMap(Post.class, ResponsePost.class).addMappings(mapper -> {
            mapper.using((Converter<City, Integer>) context -> context.getSource().getNo()).map(Post::getCity, ResponsePost::setCityNo);
            mapper.using((Converter<Sport, Integer>) context -> context.getSource().getNo()).map(Post::getSport, ResponsePost::setSportsNo);
        });
    }

    public <T> T copy(T target){
        return modelMapper.map(target, (Type) target.getClass());
    }

    public <T> T overwrite(T newOne, T oldOne){
        T result = copy(oldOne);
        modelMapper.map(newOne, result);
        return result;
    }

    public <S, D> D convert(S source, Class<D> clazz){
        return modelMapper.map(source, (Type) clazz);
    }
    public <S, D> List<D> convertList(List<S> source, Class<D> clazz){
        if(ObjectUtils.isEmpty(source)) return new ArrayList<>();
        return source.stream().map(item -> convert(item, clazz)).toList();
    }
}
