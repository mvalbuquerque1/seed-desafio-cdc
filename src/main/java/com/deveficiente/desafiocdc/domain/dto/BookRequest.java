package com.deveficiente.desafiocdc.domain.dto;

import com.deveficiente.desafiocdc.domain.entity.Author;
import com.deveficiente.desafiocdc.domain.entity.Book;
import com.deveficiente.desafiocdc.domain.entity.Category;
import com.deveficiente.desafiocdc.util.UniqueValue;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BookRequest {

    @NotEmpty
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;

    @NotEmpty
    @Size(max = 500)
    private String resume;

    private String summary;

    @NotNull
    @Min(20)
    private Long price;

    @NotNull
    @Min(100)
    private int numberOfPages;

    @NotEmpty
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private String isbn;

    //TODO data precisa ser no futuro
    @Future
    private LocalDateTime publicationDate;

    @NotNull
    @OneToOne
    private Category category;

    @NotNull
    @OneToOne
    private Author author;

    public static Book toBook(BookRequest bookRequest) {
        return Book.builder()
                .title(bookRequest.title)
                .resume(bookRequest.resume)
                .summary(bookRequest.summary)
                .price(bookRequest.price)
                .numberOfPages(bookRequest.numberOfPages)
                .isbn(bookRequest.isbn)
                .publicationDate(bookRequest.publicationDate)
                .category(bookRequest.category)
                .author(bookRequest.author)
                .build();
    }
}
