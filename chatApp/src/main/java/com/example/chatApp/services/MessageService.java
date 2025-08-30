package com.example.chatApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.chatApp.DTOs.MessageDTO;
import com.example.chatApp.models.Conversations;
import com.example.chatApp.models.Messages;
import com.example.chatApp.models.Users;
import com.example.chatApp.repositories.ConversationRepository;
import com.example.chatApp.repositories.MessageRepository;
import com.example.chatApp.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
        private final MessageRepository messageRepository;
        private final ConversationRepository conversationRepository;
        private final UserRepository userRepository;

        public List<Messages> getMessageByConversation(Integer conversationsId) {
                Conversations conversations = conversationRepository.findById(conversationsId)
                                .orElseThrow(
                                                () -> new RuntimeException("Conversation not found"));
                return messageRepository.findByConversationId(conversations);
        }

        public Messages createMessage(MessageDTO messageDTO) {
                Users newUsers = userRepository.findById(messageDTO.getSendBy())
                                .orElseThrow(() -> new RuntimeException("User not found"));
                Conversations newConversations = conversationRepository.findById(messageDTO.getConversationId())
                                .orElseThrow(() -> new RuntimeException("COnversation not found"));
                Messages newMessages = Messages.builder()
                                .content(messageDTO.getContent())
                                .sendBy(newUsers)
                                .conversationId(newConversations)
                                .status("unread")
                                .build();
                messageRepository.save(newMessages);
                return newMessages;
        }
}
