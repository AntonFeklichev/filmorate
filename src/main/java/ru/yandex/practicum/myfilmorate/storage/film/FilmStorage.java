package ru.yandex.practicum.myfilmorate.storage.film;

import ru.yandex.practicum.myfilmorate.model.Film;

import java.util.List;

public interface FilmStorage {

    Film addNewFilm(Film film);

    Film updateFilm(Film film);

    List<Film> getFilms();

    Film getFilmByIdInStorage(Long id);

    void addLikeInStorage(Long id, Long userId);

    void deleteLike(Long id, Long userId);

}
