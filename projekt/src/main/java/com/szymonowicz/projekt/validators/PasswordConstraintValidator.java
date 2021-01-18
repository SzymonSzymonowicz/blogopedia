package com.szymonowicz.projekt.validators;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(final ValidPassword arg0) {

    }

    /*
         a digit must occur at least once
         a lower case letter must occur at least once
         an upper case letter must occur at least once
         a special character must occur at least once
         no whitespace allowed in the entire string
         at least 8 characters
     */
    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {

        Pattern compiledPattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
        Matcher matcher = compiledPattern.matcher(password);

        return matcher.matches();
    }
}