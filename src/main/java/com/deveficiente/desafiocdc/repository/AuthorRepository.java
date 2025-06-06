package com.deveficiente.desafiocdc.repository;

import com.deveficiente.desafiocdc.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByEmail(String email);
}
