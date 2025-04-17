package com.deveficiente.desafiocdc.mapper;

import com.deveficiente.desafiocdc.domain.dto.CategoryRequest;
import com.deveficiente.desafiocdc.domain.dto.CategoryResponse;
import com.deveficiente.desafiocdc.domain.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "id", ignore = true)
    Category categoryRequestToCategory(CategoryRequest categoryRequest);

    CategoryResponse categoryToCategoryResponse(Category category);
}
