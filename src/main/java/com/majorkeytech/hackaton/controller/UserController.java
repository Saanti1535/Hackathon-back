package com.majorkeytech.hackaton.controller;

import com.majorkeytech.hackaton.model.User;
import com.majorkeytech.hackaton.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/1.0/users")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
