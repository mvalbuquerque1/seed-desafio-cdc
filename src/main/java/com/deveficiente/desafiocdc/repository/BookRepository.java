package com.deveficiente.desafiocdc.repository;

import com.deveficiente.desafiocdc.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
