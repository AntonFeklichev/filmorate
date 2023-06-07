package ru.yandex.practicum.myfilmorate.model;

import lombok.Data;
import ru.yandex.practicum.myfilmorate.validations.WithOutSpaces;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private Long id;
    @Email(message = "не верный формат почты")
    private String email;

    @NotBlank
    @WithOutSpaces
    private String login;
    private String name;
    @PastOrPresent
    private LocalDate birthday;

    private Set<Long> friendList = new HashSet<>();
}
