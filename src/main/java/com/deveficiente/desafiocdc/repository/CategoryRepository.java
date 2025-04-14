package com.deveficiente.desafiocdc.repository;

import com.deveficiente.desafiocdc.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByName(String name);
}
