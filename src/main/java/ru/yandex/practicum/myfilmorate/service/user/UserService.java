package ru.yandex.practicum.myfilmorate.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.myfilmorate.model.User;
import ru.yandex.practicum.myfilmorate.storage.user.UserStorage;

import java.util.List;

@Service
public class UserService {

    private final UserStorage userStorage;

    @Autowired
    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public User addNewUserInService(User user) {
        return userStorage.addNewUser(user);
    }

    public User updateUserInService(User user) {
        return userStorage.updateUser(user);
    }

    public List<User> getUsersInService() {
        return userStorage.getUsers();
    }

    public void addFriendInService(Long id, Long friendId) {
        userStorage.addFriendInStorage(id, friendId);
    }

    public void deleteFriendInService(Long id, Long friendId) {
        userStorage.deleteFriendInStorage(id, friendId);
    }

    public List<User> getMutualFriendsInService(Long id, Long otherId) {
        return userStorage.getMutualFriendsInStorage(id, otherId);
    }

    public List<User> getFriendListInService(Long id) {
        return userStorage.getFriendListInStorage(id);
    }

    public User getUserById(Long id) {
        return userStorage.getUserById(id);
    }
}


