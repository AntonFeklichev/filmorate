package ru.yandex.practicum.myfilmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.myfilmorate.model.Film;
import ru.yandex.practicum.myfilmorate.service.film.FilmService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    private static final Logger log = LoggerFactory.getLogger(FilmController.class);

    @GetMapping("/films/{id}")
    public Film getFilmById(@PathVariable
                            Long id) {
        return filmService.getFilmByIdInService(id);
    }

    @PostMapping("/films")
    public Film addNewFilm(@Valid
                           @RequestBody
                           Film film) {
        return filmService.addNewFilmInService(film);
    }

    @PutMapping("/films")
    public Film updateFilm(@Valid
                           @RequestBody
                           Film film) {
        return filmService.updateFilmInService(film);
    }

    @GetMapping("/films")
    public List<Film> getFilms() {
        return filmService.getFilmsInService();
    }

    @PutMapping("/films/{id}/like/{userId}")
    public void addLike(@PathVariable Long id,
                        @PathVariable Long userId) {
        filmService.addLikeInService(id, userId);
    }

    @DeleteMapping("/films/{id}/like/{userId}")
    public void deleteLike(@PathVariable Long id,
                           @PathVariable Long userId) {
        filmService.deleteLike(id, userId);
    }

    @GetMapping("/films/popular")
    public List<Film> getTopPopularFilms(@RequestParam(defaultValue = "10") int count) {
        return filmService.getTopPopularFilmsInService(count);
    }
}
