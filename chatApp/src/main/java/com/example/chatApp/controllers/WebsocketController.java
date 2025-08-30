package com.example.chatApp.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.chatApp.DTOs.MessageDTO;
import com.example.chatApp.models.Messages;
import com.example.chatApp.services.MessageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WebsocketController {
    private final MessageService messageService;

    @MessageMapping("/chat") // ánh xạ tin nhắn từ client đến pthuc xử lý
    @SendTo("/listen/public") // kết quả trả về trên kênh này, nơi mà các user đang lắng nghe
    public Messages sendMessage(@Payload MessageDTO chatMessage) {

        // lưu tin nhắn
        return messageService.createMessage(chatMessage);
        // System.out.println(chatMessage.getContent());
    }

}
