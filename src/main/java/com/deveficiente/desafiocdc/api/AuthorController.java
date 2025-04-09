package com.deveficiente.desafiocdc.api;

import com.deveficiente.desafiocdc.domain.Author;
import com.deveficiente.desafiocdc.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {


    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    private ResponseEntity<Author> saveAuthor(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorRepository.save(author));
    }

}
