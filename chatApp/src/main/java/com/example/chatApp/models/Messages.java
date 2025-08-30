package com.example.chatApp.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "send_by")
    private Users sendBy;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversations conversationId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private String status;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
