package ru.yandex.practicum.myfilmorate.service.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.myfilmorate.model.Film;
import ru.yandex.practicum.myfilmorate.storage.film.FilmStorage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmStorage filmStorage;


    @Autowired
    public FilmService(FilmStorage filmStorage) {
        this.filmStorage = filmStorage;
    }

    public Film addNewFilmInService(Film film) {
        return filmStorage.addNewFilm(film);
    }

    public Film updateFilmInService(Film film) {
        return filmStorage.updateFilm(film);
    }

    public List<Film> getFilmsInService() {
        return filmStorage.getFilms();
    }

    public void addLikeInService(Long id, Long userId) {
        filmStorage.addLikeInStorage(id, userId);
    }

    public void deleteLike(Long id, Long userId) {
        filmStorage.deleteLike(id, userId);
    }

    public List<Film> getTopPopularFilmsInService(int count) {
        return filmStorage.getFilms().stream()
                .sorted(Comparator.comparingInt((Film film) -> film.getLikesList().size()).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    public Film getFilmByIdInService(Long id) {
        return filmStorage.getFilmByIdInStorage(id);
    }

}


