package com.deveficiente.desafiocdc.repository;

import com.deveficiente.desafiocdc.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
