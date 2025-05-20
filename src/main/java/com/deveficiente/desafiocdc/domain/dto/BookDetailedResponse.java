package com.deveficiente.desafiocdc.domain.dto;

import com.deveficiente.desafiocdc.domain.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailedResponse {

    private String title;
    private String resume;
    private String summary;
    private Long price;
    private int numberOfPages;
    private String isbn;
    private LocalDateTime publicationDate;
    private Author author;
}
