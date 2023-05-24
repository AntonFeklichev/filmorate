package ru.yandex.practicum.myfilmorate.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;

public class DurationValidator implements ConstraintValidator<DurationValidation, Duration> {

    @Override
    public boolean isValid(Duration value, ConstraintValidatorContext context) {
        return (!value.isNegative());
    }
}
