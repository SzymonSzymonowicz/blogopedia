package com.szymonowicz.projekt.validators;

import com.szymonowicz.projekt.dto.AuthorDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final AuthorDTO author = (AuthorDTO) obj;
        return author.getPassword().equals(author.getMatchingPassword());
    }

}
