package ru.yandex.practicum.myfilmorate.storage.user;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.myfilmorate.exceptions.NonFoundException;
import ru.yandex.practicum.myfilmorate.model.User;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class InMemoryUserStorage implements UserStorage {

    private Long nextId = 1L;

    public Map<Long, User> users = new HashMap<>();


    @Override
    public User addNewUser(User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            user.setName(user.getLogin());
        }
        Long id = generateId();
        user.setId(id);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        if (!users.containsKey(user.getId())) {
            throw new NonFoundException("Пользователь не существует");
        } else {
            users.put(user.getId(), user);
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void addFriendInStorage(Long id, Long friendId) {
        if(!users.containsKey(id) || !users.containsKey(friendId)) {
           throw new NonFoundException("Пользователь с таким iD не найден");
        }
        users.get(id).getFriendList().add(users.get(friendId).getId());
        users.get(friendId).getFriendList().add(users.get(id).getId());
    }

    @Override
    public void deleteFriendInStorage(Long id, Long friendId) {
        users.get(id).getFriendList().remove(users.get(friendId).getId());
    }

    @Override
    public List<User> getMutualFriendsInStorage(Long id, Long otherId) {
        nullCheck(id, otherId);
        List<User> mutualFriendsList = users.get(id).getFriendList().stream()
                .filter(users.get(otherId).getFriendList()::contains)
                .map(users::get)
                .collect(Collectors.toList());
        return mutualFriendsList;
    }

    @Override
    public List<User> getFriendListInStorage(Long id) {
        Set<Long> friendsId = users.get(id).getFriendList();

        return friendsId.stream()
                .map(users::get)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long id) {
        if (!users.containsKey(id)) {
            throw new NonFoundException("Пользователь не найден");
        }
        return users.get(id);
    }


    private Long generateId() {
        return nextId++;
    }

    public void nullCheck (Long id, Long otherId) {
        if (!users.containsKey(id) || !users.containsKey(otherId)) {
            throw new NonFoundException("Пользователь с таким ID не найден");
        }
    }
}
