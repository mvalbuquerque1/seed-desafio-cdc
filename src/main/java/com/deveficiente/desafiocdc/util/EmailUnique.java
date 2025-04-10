package com.deveficiente.desafiocdc.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailUniqueValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnique {

    String message() default "Email is already is use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
