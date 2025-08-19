package com.example.chatApp.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "conversation_members")
@NoArgsConstructor

public class ConversationMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversations conversationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;
}
