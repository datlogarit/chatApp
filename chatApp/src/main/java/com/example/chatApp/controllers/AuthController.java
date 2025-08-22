package com.example.chatApp.controllers;

import com.example.chatApp.DTOs.UserDTO;
import com.example.chatApp.models.Users;
import com.example.chatApp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// @RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {// Model la dai dien cho du lieu dc truyen tu Controller sang cho view
        model.addAttribute("user", new Users()); // object trống để binding với form
        return "register";
    }

    @PostMapping("/register")
    public String processingRegister(@ModelAttribute("user") UserDTO userDTO,
            @RequestParam("confirmPassword") String confirmPassword,
            Model model) {
        if (!userDTO.getPassword().equals(confirmPassword)) {
            model.addAttribute("errorMsg", "confirmPassword not correct");
            return "register";
        }
        // luu user
        userService.register(userDTO);
        return "redirect:/login";
    }
}
