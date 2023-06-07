package ru.yandex.practicum.myfilmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.myfilmorate.model.User;
import ru.yandex.practicum.myfilmorate.service.user.UserService;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);



    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
       return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addNewUser(@Valid
                           @RequestBody
                           User user) {
        return userService.addNewUserInService(user);
    }

    @PutMapping("/users")
    public User updateUser(@Valid
                           @RequestBody
                           User user) {
        return userService.updateUserInService(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsersInService();
    }

    @PutMapping("/users/{id}/friends/{friendId}")
    public void addFriend(@PathVariable Long id,
                          @PathVariable Long friendId) {
        userService.addFriendInService(id, friendId);
    }

    @DeleteMapping("/users/{id}/friends/{friendId}")
    public void deleteFriend(@PathVariable Long id,
                             @PathVariable Long friendId) {
        userService.deleteFriendInService(id, friendId);
    }

    @GetMapping("/users/{id}/friends/common/{otherId}")
    public List<User> getMutualFriends(@PathVariable Long id,
                                       @PathVariable Long otherId) {
        return userService.getMutualFriendsInService(id, otherId);
    }

    @GetMapping("/users/{id}/friends")
    List<User> getFriendList(@PathVariable Long id) {
        return userService.getFriendListInService(id);
    }

}
