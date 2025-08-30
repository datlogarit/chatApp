package com.example.chatApp.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.chatApp.DTOs.MessageTest;

@Controller

public class WebsocketController {
    @MessageMapping("/chat") // ánh xạ tin nhắn từ client đến pthuc xử lý
    @SendTo("/listen/public") // kết quả trả về trên kênh này, nơi mà các user đang lắng nghe
    public MessageTest sendMessage(@Payload MessageTest chatMessage) {
        return chatMessage;
        // System.out.println(chatMessage.getContent());
    }

}
