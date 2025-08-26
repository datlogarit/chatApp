package com.example.chatApp.models;

import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member_of_conversation")
@Immutable
@Getter
@Setter
public class MemberOfConversation {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room_owner")
    private Users roomOwner;

    private String name;

    private String type;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;

}
