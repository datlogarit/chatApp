package com.example.chatApp.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private String content;

    private Integer sendBy;

    private Integer conversationId;

    private String status;
}
