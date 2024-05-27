package com.codecrafters.companity.config.mapper;
import java.util.List;

public interface CompanityObjectMapper {
    <T> T copy(T target);

    <T> T overwrite(T target, T destination);

    <S, D> D convert(S source, Class<D> clazz);

    <S, D> List<D> convertList(List<S> source, Class<D> clazz);
}
