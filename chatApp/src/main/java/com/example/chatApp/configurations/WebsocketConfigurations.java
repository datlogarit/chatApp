package com.example.chatApp.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfigurations implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Cấu hình tiền tố cho các topic mà client có thể đăng ký - nghe sự thay đổi
        registry.enableSimpleBroker("/listen");
        // Cấu hình tiền tố cho các endpoint ứng dụng mà client gửi tin nhắn đến - gửi
        // dữ liệu
        registry.setApplicationDestinationPrefixes("/send");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint lắng nghe kết nối từ frontend
        registry.addEndpoint("/openws").setAllowedOrigins("http://localhost:8088").withSockJS();
    }

}
