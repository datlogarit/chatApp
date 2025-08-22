package com.example.chatApp.exceptions;

import com.example.chatApp.models.Users;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHander {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handleUserExists(UserAlreadyExistsException ex, Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("errorMsg", ex.getMessage());
        return "register";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFound(UserNotFoundException ex, Model model) {
        model.addAttribute("errorMsg", ex.getMessage());
        return "login";
    }
}
