package com.example.chatApp.controllers;

import com.example.chatApp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    private ResponseEntity<?> getUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/login")
    private ResponseEntity<?> login(){
        return ResponseEntity.ok("Login successfully");
    }

    @GetMapping("/signUp")
    private ResponseEntity<?> signUp(){
        return ResponseEntity.ok("Sign up successfully");
    }
}
