package com.codehub.manytomany.leethub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codehub.manytomany.leethub.model.User;
import com.codehub.manytomany.leethub.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public User getUserById(@PathVariable Long user_id) {
        Optional<User> user = userService.getUserById(user_id);
        if (user.isPresent()) {
            return user.get();

        } else {
            return new User();
        }
    }

    @DeleteMapping("/{user_id}")
    public void deleteUserById(@PathVariable Long user_id) {
        userService.deleteUserById(user_id);
    }

}