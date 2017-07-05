package com.pastwisko.controller;

import com.pastwisko.model.User;
import com.pastwisko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/users")
    public List<User> list() {
        return userService.listAll();
    }

    @GetMapping("api/users/{id}")
    public User user(@PathVariable int id) {
        return userService.getById(id);
    }
}
