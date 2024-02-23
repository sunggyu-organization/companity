package com.codecrafters.companity.adapter.utility;

import com.codecrafters.companity.application.out.utility.CompanityObjectMapper;
import org.modelmapper.ModelMapper;
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
        modelMapper.getConfiguration().setSkipNullEnabled(true);
    }
    public <T> T copy(T target){
        return modelMapper.map(target, (Type) target.getClass());
    }

    public <T> T overwrite(T target, T destination){
        T result = copy(destination);
        modelMapper.map(target, result);
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
