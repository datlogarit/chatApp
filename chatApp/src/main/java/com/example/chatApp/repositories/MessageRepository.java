package com.example.chatApp.repositories;

import com.example.chatApp.models.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages, Integer> {
}
