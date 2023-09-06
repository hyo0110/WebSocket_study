package com.websocket.config;

import com.websocket.handler.WebSocketChatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//@RequiredArgsConstructor
@Configuration
@EnableWebSocket
public class WebSocketConfiger implements WebSocketConfigurer {
    private final WebSocketChatHandler webSocketChatHandler;

    public WebSocketConfiger(WebSocketChatHandler webSocketChatHandler) {
        this.webSocketChatHandler = webSocketChatHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketChatHandler, "/ws/chat").setAllowedOrigins("*");
    }
}