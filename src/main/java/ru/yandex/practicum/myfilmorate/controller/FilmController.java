package ru.yandex.practicum.myfilmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.myfilmorate.exceptions.NonFoundException;
import ru.yandex.practicum.myfilmorate.exceptions.ValidationException;
import ru.yandex.practicum.myfilmorate.model.Film;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FilmController {

    private Long nextId = 1L;

    private static final Logger log = LoggerFactory.getLogger(FilmController.class);

    private Map<Long, Film> films = new HashMap<>();

    @PostMapping("/films")
    public Film addNewFilm(@Valid @RequestBody Film film) {

        if (films.containsKey(film.getId())) {
            throw new ValidationException("Фильм существует");
        }
        Long id = generateId();
        film.setId(id);
        films.put(film.getId(), film);
        return film;
    }

    @PutMapping("/films")
    public Film updateFilm(@Valid @RequestBody Film film) {

        if (films.containsKey(film.getId())) {
            films.put(film.getId(), film);
            return film;
        } else {
            throw new NonFoundException("Фильм не существует");
        }

    }

    @GetMapping("/films")
    public List<Film> getFilms() {
        return new ArrayList<>(films.values());
    }

    private Long generateId() {
        return nextId++;
    }

}
