package com.deveficiente.desafiocdc.domain.entity;

import com.deveficiente.desafiocdc.domain.dto.BookDetailedResponse;
import com.deveficiente.desafiocdc.domain.dto.ListBookResponse;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
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
    private String isbn;

    private LocalDateTime publicationDate;

    @NotNull
    @ManyToOne
    private Category category;

    @NotNull
    @ManyToOne
    private Author author;

    public static List<ListBookResponse> toListBookResponse(List<Book> books) {
        return books.stream()
                .map(book -> ListBookResponse.builder()
                        .id(book.id)
                        .title(book.title)
                        .build())
                .toList();
    }

    public static BookDetailedResponse toBookDetailedResponse(Book book) {
       return BookDetailedResponse.builder()
               .title(book.getTitle())
               .resume(book.getResume())
               .summary(book.getSummary())
               .price(book.getPrice())
               .isbn(book.getIsbn())
               .publicationDate(book.getPublicationDate())
               .author(book.getAuthor())
               .build();
    }
}
