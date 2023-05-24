package ru.yandex.practicum.myfilmorate.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class ClassReleaseDateValidator implements ConstraintValidator<ReleaseDateValidation, LocalDate> {
    @Override
    public boolean isValid(LocalDate LocalDate, ConstraintValidatorContext context) {
        return !LocalDate.isBefore(LocalDate.of(1895, 12, 28));
    }


}
