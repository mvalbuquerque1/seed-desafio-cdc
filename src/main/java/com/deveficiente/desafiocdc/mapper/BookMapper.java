package com.deveficiente.desafiocdc.mapper;

import com.deveficiente.desafiocdc.domain.dto.BookDetailedResponse;
import com.deveficiente.desafiocdc.domain.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDetailedResponse toBookDetailedResponse(Book book);
}
