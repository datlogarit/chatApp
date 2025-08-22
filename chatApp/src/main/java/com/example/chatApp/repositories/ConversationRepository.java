package com.example.chatApp.repositories;

import com.example.chatApp.models.Conversations;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConversationRepository extends JpaRepository<Conversations, Integer> {
    @Query("SELECT * FROM member_conversation c WHERE c.id = :id")
    Optional<Conversations> findConversationByUserId(@Param("id") Integer id);
}
