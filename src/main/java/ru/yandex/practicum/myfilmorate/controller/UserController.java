package ru.yandex.practicum.myfilmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.myfilmorate.exceptions.NonFoundException;
import ru.yandex.practicum.myfilmorate.exceptions.ValidationException;
import ru.yandex.practicum.myfilmorate.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UserController {

    private Long nextId = 1L;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private Map<Long, User> users = new HashMap<>();

    @PostMapping("/users")
    public User addNewUser(@Valid @RequestBody User user) {
        if ( user.getName() == null || user.getName().isBlank()) {
            user.setName(user.getLogin());
        }
        Long id = generateId();
        user.setId(id);
        users.put(user.getId(), user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@Valid @RequestBody User user) {
        if (!users.containsKey(user.getId())) {
            throw new NonFoundException("Пользователь не существует");
        } else {
            users.put(user.getId(), user);
        }
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    private Long generateId() {
        return nextId++;
    }
}
