package com.deveficiente.desafiocdc.util;

import com.deveficiente.desafiocdc.repository.CategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class NameUniqueValidator implements ConstraintValidator<NameUnique, String> {

    private final CategoryRepository categoryRepository;

    public NameUniqueValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (name == null || name.isBlank()) return true;
        return categoryRepository.findByName(name).isEmpty();
    }
}
