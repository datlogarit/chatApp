package com.example.chatApp.DTOs;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageTest {
    private String sender; // hoặc lấy từ user login
    private String content;
    private LocalDateTime createdAt;
}
