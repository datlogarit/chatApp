package com.example.chatApp.repositories;

import com.example.chatApp.DTOs.ConversationListDTO;
import com.example.chatApp.models.Conversations;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConversationRepository extends JpaRepository<Conversations, Integer> {
       // @Query(value = "SELECT m FROM MemberOfConversation m WHERE m.userId.id != :id
       // và cùng conversation với user dang truyen")
       // List<MemberOfConversation> findListConversationByUserId(@Param("id") Integer
       // id);
       @Query(value = """
                     SELECT c.id AS conversationId,
                            c.name AS conversationName,
                            c.type AS type,
                            u.id AS partnerId,
                            u.user_name AS partnerUsername,
                            m.id AS lastMessageId,
                            m.content AS lastMessage,
                            m.created_at AS lastMessageTime,
                            m.send_by AS lastMessageSendBy
                     FROM conversations c
                     JOIN conversation_members cm ON cm.conversation_id = c.id
                     JOIN conversation_members cm2 ON cm2.conversation_id = c.id
                     JOIN users u ON u.id = cm2.user_id
                     LEFT JOIN messages m
                            ON m.id = (
                                 SELECT m2.id
                                 FROM messages m2
                                 WHERE m2.conversation_id = c.id
                                 ORDER BY m2.created_at DESC
                                 LIMIT 1
                            )
                     WHERE cm.user_id = :userId
                       AND cm2.user_id <> :userId
                     """, nativeQuery = true)
       List<ConversationListDTO> findConversationsByUserId(@Param("userId") Integer userId);

}
