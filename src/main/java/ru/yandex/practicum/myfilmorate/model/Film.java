package ru.yandex.practicum.myfilmorate.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import ru.yandex.practicum.myfilmorate.validations.DurationValidation;
import ru.yandex.practicum.myfilmorate.validations.ReleaseDateValidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.LocalDate;

@Data
public class Film {

    private Long id;

    @NotBlank
    private String name;
    @Size(max = 200, message = "максимальна длина 200 символов")
    private String description;

    @ReleaseDateValidation
    private LocalDate releaseDate;
    @Positive
    //@JsonSerialize(using = DurationJsonSerializer.class)
    private int duration;


}
