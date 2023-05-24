package ru.yandex.practicum.myfilmorate.validations;

import javax.validation.Constraint;

@Constraint(validatedBy = DurationValidator.class)
public @interface DurationValidation {
}
