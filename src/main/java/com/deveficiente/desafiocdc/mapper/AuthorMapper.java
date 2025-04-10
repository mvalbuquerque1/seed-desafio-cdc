package com.deveficiente.desafiocdc.mapper;

import com.deveficiente.desafiocdc.domain.dto.AuthorRequest;
import com.deveficiente.desafiocdc.domain.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "createdAt", ignore = true)
    Author authorRequestToAuthor(AuthorRequest request);
}
