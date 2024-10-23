package com.galata.codingapp.controller;

import com.galata.codingapp.model.User;
import com.galata.codingapp.service.UserService;
import com.galata.codingapp.model.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity <String> signup(@RequestBody AuthRequest authRequest) {
        User newUser = new User();
        newUser.setUsername(authRequest.getUsername());
        newUser.setPassword(authRequest.getPassword());
        newUser.setEmail(authRequest.getEmail());

        userService.createUser(newUser);
        return ResponseEntity.ok("User created");
    }

    @PostMapping("/login")
    public ResponseEntity <String> login(@RequestBody AuthRequest authRequest) {
        boolean isAuthenticated = userService.authenticate(authRequest.getUsername(),authRequest.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok("User logged in");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
