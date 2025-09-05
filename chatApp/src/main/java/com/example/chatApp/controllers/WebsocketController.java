package com.example.chatApp.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.chatApp.DTOs.MessageDTO;
import com.example.chatApp.models.Messages;
import com.example.chatApp.services.MessageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WebsocketController {
    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat") // ánh xạ tin nhắn từ client đến phương thức xử lý
    public void sendMessage(@Payload MessageDTO chatMessage) {
        // lưu tin nhắn vào database
        Messages savedMessage = messageService.createMessage(chatMessage);

        // gửi tin nhắn đến kênh riêng của cuộc trò chuyện
        String destination = "/listen/conversation/" + chatMessage.getConversationId();
        messagingTemplate.convertAndSend(destination, savedMessage);
        messagingTemplate.convertAndSend("/listen/sidebar", savedMessage);
    }

}
