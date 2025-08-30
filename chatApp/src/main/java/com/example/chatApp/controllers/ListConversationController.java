package com.example.chatApp.controllers;

import java.util.List;

import com.example.chatApp.DTOs.ConversationListDTO;
import com.example.chatApp.models.Users;
import com.example.chatApp.repositories.UserRepository;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
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
    private final UserRepository userRepository;
    // @GetMapping("/chat")
    // public String chatPage() {
    // return "chat";
    // }

    // @GetMapping("/chat/{conversationId}")
    // public String chatWithConversationPage(@PathVariable("conversationId")
    // Integer conversationId, Model model) {
    // // Placeholder: thêm logic để lấy dữ liệu chat từ conversationId; sau sẽ bind
    // từ
    // // service
    // // model.addAttribute("chatData", chatService.getChatData(conversationId));
    // return "chat_conversation";
    // }

    @GetMapping("/chat/user/{userId}")
    public String chatList(@PathVariable("userId") Integer userId, Model model, Authentication authentication) {
        List<ConversationListDTO> conversations = conversationService.getListConversations(userId);
        String username = authentication.getName();
        Users usersLogged = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Username not found"));
        Integer userIdLogged = usersLogged.getId();
        if (userId != userIdLogged) {
            // throw new AccessDeniedException("You do not have permission to access this
            // page");
            return "redirect:/login?noPermission";
        }
        // láy đc hết thông tin của trang listConversation ở đây để truyền vào cho view
        model.addAttribute("userId", userId);
        model.addAttribute("conversations", conversations);
        return "chat";
    }
}
