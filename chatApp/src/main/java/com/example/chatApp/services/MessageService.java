package com.example.chatApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.chatApp.models.Conversations;
import com.example.chatApp.models.Messages;
import com.example.chatApp.repositories.ConversationRepository;
import com.example.chatApp.repositories.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;

    public List<Messages> getMessageByConversation(Integer conversationsId) {
        Conversations conversations = conversationRepository.findById(conversationsId)
                .orElseThrow(
                        () -> new RuntimeException("Conversation not found"));
        return messageRepository.findByConversationId(conversations);
    }
}
