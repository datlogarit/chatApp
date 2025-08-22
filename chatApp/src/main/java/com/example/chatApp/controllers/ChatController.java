package com.example.chatApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class ChatController {
    @GetMapping("/chat")
    public String chatPage() {
        return "chat";
    }

    @GetMapping("/chat/search")
    public String chatWithSearchPage() {
        return "chat_search";
    }

    @GetMapping("/friends")
    public String friendsPage(Model model) {
        // Placeholder: thêm danh sách bạn bè mẫu; sau sẽ bind từ service
        // model.addAttribute("friends", friendsService.getFriendsOfCurrentUser());
        return "friends";
    }

    @PostMapping("/friends/{friendId}/delete")
    public String deleteFriend(@PathVariable("friendId") Integer friendId) {
        return "redirect:/friends";
    }
}
