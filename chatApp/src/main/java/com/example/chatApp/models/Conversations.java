package com.example.chatApp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.security.core.userdetails.User;

import java.sql.Date;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "conversations")
public class Conversations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String type;

    @ManyToOne
    @JoinColumn(name = "room_owner")
    private Users roomOwner;

    @Column(name = "created_at")
    private Date createdAt;
}
