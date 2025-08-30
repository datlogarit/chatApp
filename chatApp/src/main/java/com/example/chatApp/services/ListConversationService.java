package com.example.chatApp.services;

import java.util.List;

import com.example.chatApp.DTOs.ConversationListDTO;
import com.example.chatApp.repositories.ConversationRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListConversationService {
    private final ConversationRepository conversationRepository;

    public List<ConversationListDTO> getListConversations(Integer userId) {
        // xem user đó có những cuộc trò chuyện nào
        List<ConversationListDTO> listMOC = conversationRepository.findConversationsByUserId(userId);
        // xem cuộc trò chuyện đó là với ai (hiển thị trên list)

        return listMOC;
    }
}
