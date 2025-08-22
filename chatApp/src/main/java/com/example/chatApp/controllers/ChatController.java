package com.example.chatApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.chatApp.repositories.ConversationRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ConversationRepository conversationRepository;

    @GetMapping("/chat")
    public String chatPage() {
        return "chat";
    }

    @GetMapping("/chat/{conversationId}")
    public String chatWithConversationPage(@PathVariable("conversationId") Integer conversationId, Model model) {
        // Placeholder: thêm logic để lấy dữ liệu chat từ conversationId; sau sẽ bind từ
        // service
        // model.addAttribute("chatData", chatService.getChatData(conversationId));
        return "chat_conversation";
    }

    @GetMapping("chat/{userId}")
    public String chatList(@PathVariable("userId") Integer userId, Model model) {
        conversationRepository.findConversationByUserId(userId);
        // Placeholder: thêm logic để lấy dữ liệu chat từ userId; sau sẽ bind từ service
        // model.addAttribute("chatData", chatService.getChatData(userId));
        return "chat_user";
    }
}
