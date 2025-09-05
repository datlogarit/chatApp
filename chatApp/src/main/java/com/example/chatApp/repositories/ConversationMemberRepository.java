package com.example.chatApp.repositories;

import com.example.chatApp.models.ConversationMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConversationMemberRepository extends JpaRepository<ConversationMembers, Integer> {
    List<ConversationMembers> findByConversationIdId(Integer conversationId);
}
