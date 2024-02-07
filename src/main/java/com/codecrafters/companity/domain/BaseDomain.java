package com.codecrafters.companity.domain;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

public abstract class BaseDomain {
    protected <T> T copy(ModelMapper modelMapper, T target){
        modelMapper.getConfiguration().setDeepCopyEnabled(true);
        return modelMapper.map(target, (Type) target.getClass());
    }

}
