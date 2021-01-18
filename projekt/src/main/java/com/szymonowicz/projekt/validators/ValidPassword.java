package com.szymonowicz.projekt.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface ValidPassword {

    String message() default "         a digit must occur at least once\n" +
            "         a lower case letter must occur at least once\n" +
            "         an upper case letter must occur at least once\n" +
            "         a special character must occur at least once\n" +
            "         no whitespace allowed in the entire string\n" +
            "         at least 8 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}