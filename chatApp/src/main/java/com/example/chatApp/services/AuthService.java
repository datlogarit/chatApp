package com.example.chatApp.services;

import com.example.chatApp.DTOs.UserDTO;
import com.example.chatApp.exceptions.UserAlreadyExistsException;
import com.example.chatApp.models.Users;
import com.example.chatApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Users getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    public void register(UserDTO userDTO) throws RuntimeException {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new UserAlreadyExistsException("User already exists");
        }
        Users users = Users.builder()
                .username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();
        userRepository.save(users);
    }

    public Users login(String username, String password) {
        Users users = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("user not found"));
        if (!passwordEncoder.matches(password, users.getPassword())) {
            throw new RuntimeException("Password not match");
        } else {
            return users;
        }
    }
}
