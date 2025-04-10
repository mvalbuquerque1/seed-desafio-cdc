package com.deveficiente.desafiocdc.util;

import com.deveficiente.desafiocdc.repository.AuthorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

    private final AuthorRepository authorRepository;

    public EmailUniqueValidator(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isBlank()) return true;
        return authorRepository.findByEmail(email).isEmpty();

    }
}
