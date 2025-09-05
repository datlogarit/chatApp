package com.example.chatApp.DTOs;

import java.time.LocalDateTime;

public interface ConversationListDTO {
    Long getConversationId();

    String getConversationName();

    String getType();

    Long getPartnerId();

    String getPartnerUsername();

    Long getLastMessageId();

    String getLastMessage();

    LocalDateTime getLastMessageTime();

    Long getLastMessageSendBy();
}
