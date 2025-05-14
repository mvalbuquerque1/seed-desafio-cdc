package com.deveficiente.desafiocdc.api;

import com.deveficiente.desafiocdc.domain.dto.BookRequest;
import com.deveficiente.desafiocdc.domain.dto.ListBookResponse;
import com.deveficiente.desafiocdc.domain.entity.Book;
import com.deveficiente.desafiocdc.repository.BookRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.deveficiente.desafiocdc.domain.entity.Book.toListBookResponse;

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

    @GetMapping
    public ResponseEntity<List<ListBookResponse>> listAll() {
        List<ListBookResponse> listBookResponse = toListBookResponse(bookRepository.findAll());
        return ResponseEntity.ok(listBookResponse);
    }
}
