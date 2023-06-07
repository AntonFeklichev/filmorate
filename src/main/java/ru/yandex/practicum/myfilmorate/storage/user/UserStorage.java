package ru.yandex.practicum.myfilmorate.storage.user;

import ru.yandex.practicum.myfilmorate.model.User;

import java.util.List;


public interface UserStorage {

    User addNewUser(User user);

    User updateUser(User user);

    List<User> getUsers();

    void addFriendInStorage(Long id, Long friendId);

    void deleteFriendInStorage(Long id, Long friendId);

    List<User> getMutualFriendsInStorage(Long id, Long otherId);

    List<User> getFriendListInStorage(Long id);

    User getUserById(Long id);

}
