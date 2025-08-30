package com.example.chatApp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatApp.services.MessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MessageController {
    private final MessageService messageService;

    @GetMapping("conversation/message/{conversationId}")
    public ResponseEntity<?> getMessageByConversationId(@PathVariable("conversationId") Integer conversationId) {

        return ResponseEntity.ok(messageService.getMessageByConversation(conversationId));

    }
}
