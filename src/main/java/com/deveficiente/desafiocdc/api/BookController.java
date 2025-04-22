package com.deveficiente.desafiocdc.api;

import com.deveficiente.desafiocdc.domain.dto.BookRequest;
import com.deveficiente.desafiocdc.domain.entity.Book;
import com.deveficiente.desafiocdc.repository.BookRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Book> saveBook(@RequestBody @Valid BookRequest bookRequest) {
        Book book = BookRequest.toBook(bookRequest);
        return ResponseEntity.ok(bookRepository.save(book));
    }
}
