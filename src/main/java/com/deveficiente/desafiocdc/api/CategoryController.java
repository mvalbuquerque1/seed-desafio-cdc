package com.deveficiente.desafiocdc.api;

import com.deveficiente.desafiocdc.domain.dto.CategoryRequest;
import com.deveficiente.desafiocdc.domain.dto.CategoryResponse;
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
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category categoryToSave = categoryMapper.categoryRequestToCategory(categoryRequest);

        Category savedCategory = categoryRepository.save(categoryToSave);
        CategoryResponse response = categoryMapper.categoryToCategoryResponse(savedCategory);

        return ResponseEntity.ok(response);
    }
}
