package com.ethan.ai115.pixelcollector.controller;

import com.ethan.ai115.pixelcollector.dto.LoginDto;
import com.ethan.ai115.pixelcollector.model.User;
import com.ethan.ai115.pixelcollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerNewUser(@RequestBody User newUser) {
        User user = userService.registerNewUser(newUser);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody LoginDto loginData) {
        User user = userService.loginUser(loginData.getUsername(), loginData.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }

}
