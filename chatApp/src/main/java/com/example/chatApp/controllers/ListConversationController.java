package com.example.chatApp.controllers;

import java.util.List;

import com.example.chatApp.DTOs.ConversationListDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.chatApp.services.ListConversationService;

import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class ListConversationController {
    private final ListConversationService conversationService;

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

    @GetMapping("/chat/user/{userId}")
    public String chatList(@PathVariable("userId") Integer userId, Model model) {
        List<ConversationListDTO> conversations = conversationService.getListConversations(userId);
        // láy đc hết thông tin của trang listConversation ở đây để truyền vào cho view
        model.addAttribute("conversations", conversations);
        return "chat";
    }
}
