package com.example.chatApp.services;

import java.util.List;

import com.example.chatApp.models.Conversations;
import com.example.chatApp.repositories.ConversationRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConversationService {
    private final ConversationRepository conversationRepository;

    public List<Conversations> getConversationsByUserId(Integer userId) {
        return conversationRepository.findConversationByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));
    }
}
