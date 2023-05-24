package ru.yandex.practicum.myfilmorate.validations;

import javax.validation.Constraint;

@Constraint(validatedBy = SpaceValidator.class)
public @interface WithOutSpaces {
}
