package com.majorkeytech.hackaton.controller;

import com.majorkeytech.hackaton.businessExceptions.DataConsistencyException;
import com.majorkeytech.hackaton.model.User;
import com.majorkeytech.hackaton.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/1.0/users/create")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }
    
    @PostMapping("/api/1.0/users/login")
    public void login(@RequestParam String email, @RequestParam String password) {
       userService.login(email, password);
   }
    
    @PutMapping("/api/1.0/users/update")
    public void updateUser(@RequestBody User updatedUser) throws DataConsistencyException {
    	userService.update(updatedUser);
    }
    
    @GetMapping("/api/1.0/users/getAll")
    public List<User> getUsers() {
    	return userService.getAll();
    }
}
