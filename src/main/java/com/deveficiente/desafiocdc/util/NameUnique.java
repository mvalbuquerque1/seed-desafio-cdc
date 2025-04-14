package com.deveficiente.desafiocdc.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameUniqueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameUnique {

    String message() default "Name is already in use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
