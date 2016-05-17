package com.shop.mapper;

import java.util.List;

/**
 * Created by dobodzinskiy on 15.03.2016.
 */
public interface Mapper<T, TDto> {
    T fromDto(TDto tDto);
    TDto toDto(T t);
    List<TDto> toDtoList(List<T> ts);
    List<T> fromDtoList(List<TDto> tDtos);
}
