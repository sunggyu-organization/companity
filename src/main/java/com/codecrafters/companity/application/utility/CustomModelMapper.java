package com.codecrafters.companity.application.utility;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class CustomModelMapper {
    private final ModelMapper modelMapper;
    public CustomModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
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

}
