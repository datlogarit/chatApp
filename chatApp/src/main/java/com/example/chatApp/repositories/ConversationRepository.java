package com.example.chatApp.repositories;

import com.example.chatApp.models.Conversations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversations, Integer> {
}
