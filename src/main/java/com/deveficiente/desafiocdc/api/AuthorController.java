package com.deveficiente.desafiocdc.api;

import com.deveficiente.desafiocdc.domain.dto.AuthorRequest;
import com.deveficiente.desafiocdc.domain.entity.Author;
import com.deveficiente.desafiocdc.mapper.AuthorMapper;
import com.deveficiente.desafiocdc.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody @Valid AuthorRequest authorRequest) {
        Author savedAuthor = authorMapper.authorRequestToAuthor(authorRequest);
        savedAuthor.setCreatedAt(LocalDateTime.now());
        return ResponseEntity.ok(authorRepository.save(savedAuthor));
    }

}
