package com.codecrafters.companity.domain;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

public abstract class BaseDomain {
    protected <T> T copy(ModelMapper modelMapper, T target){
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper.map(target, (Type) target.getClass());
    }

    protected <T> T overwrite(ModelMapper modelMapper, T target, T destination){
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        T result = copy(modelMapper, destination);
        modelMapper.map(target, result);
        return result;
    }

}
