package com.pastwisko.controller;

import com.pastwisko.model.RegisteringUser;
import com.pastwisko.model.User;
import com.pastwisko.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping("api/users/{userName}")
    public ResponseEntity getUser(@PathVariable String userName) {
        User user = userService.findByUserName(userName);

        if (user == null)
            return ResponseEntity.badRequest().body("User not found");

        return ResponseEntity.ok(user);
    }

    @PostMapping("api/auth/register")
    public ResponseEntity registerNewUser(@RequestBody RegisteringUser user) {

        if (user == null)
            return ResponseEntity.badRequest().body("User is null");

        // Map registered user to user
        User newUser = new User();
        newUser.setUserName(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setMail(user.getEmail());

        userService.saveOrUpdate(newUser);

        return ResponseEntity.ok(user);
    }

}
