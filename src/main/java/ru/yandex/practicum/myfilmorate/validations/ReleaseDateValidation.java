package ru.yandex.practicum.myfilmorate.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClassReleaseDateValidator.class)
public @interface ReleaseDateValidation {
    String message() default "Invalid release date: must be after December 28, 1895";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
