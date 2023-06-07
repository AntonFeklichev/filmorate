package ru.yandex.practicum.myfilmorate.storage.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.myfilmorate.exceptions.NonFoundException;
import ru.yandex.practicum.myfilmorate.exceptions.ValidationException;
import ru.yandex.practicum.myfilmorate.model.Film;
import ru.yandex.practicum.myfilmorate.storage.user.UserStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryFilmStorage implements FilmStorage {

    private final UserStorage userStorage;

    @Autowired
    public InMemoryFilmStorage(UserStorage userStorage) {
        this.userStorage = userStorage;
    }


    private Long nextId = 1L;

    private Map<Long, Film> films = new HashMap<>();

    @Override
    public Film addNewFilm(Film film) {
        if (films.containsKey(film.getId())) {
            throw new ValidationException("Фильм существует");
        }
        Long id = generateId();
        film.setId(id);
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public Film updateFilm(Film film) {
        if (films.containsKey(film.getId())) {
            films.put(film.getId(), film);
            return film;
        } else {
            throw new NonFoundException("Фильм не существует");
        }
    }

    @Override
    public List<Film> getFilms() {
        return new ArrayList<>(films.values());
    }

    private Long generateId() {
        return nextId++;
    }

    @Override
    public Film getFilmByIdInStorage(Long id) {
        if(!films.containsKey(id)) {
            throw new NonFoundException("Фильм с таким id не гайден");
        }
        return films.get(id);
    }

    @Override
    public void addLikeInStorage(Long id, Long userId) {
        films.get(id).getLikesList().add(userStorage.getUserById(userId).getId());
    }

    @Override
    public void deleteLike(Long id, Long userId) {
        films.get(id).getLikesList().remove(userStorage.getUserById(userId).getId());
    }
}
