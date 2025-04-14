package com.deveficiente.desafiocdc.api;

import com.deveficiente.desafiocdc.domain.dto.CategoryRequest;
import com.deveficiente.desafiocdc.domain.entity.Category;
import com.deveficiente.desafiocdc.mapper.CategoryMapper;
import com.deveficiente.desafiocdc.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category categoryToSave = CategoryMapper.INSTANCE.toCategory(categoryRequest);
        return ResponseEntity.ok(categoryRepository.save(categoryToSave));
    }
}
