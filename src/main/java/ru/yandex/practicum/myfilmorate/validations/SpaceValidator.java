package ru.yandex.practicum.myfilmorate.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SpaceValidator implements ConstraintValidator<WithOutSpaces, String> {

    @Override
    public boolean isValid(String string, ConstraintValidatorContext context) {
        return !string.contains(" ");
    }
}

