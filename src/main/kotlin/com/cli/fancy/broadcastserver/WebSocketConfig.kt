package com.cli.fancy.broadcastserver

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.session.Session
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer


@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
class WebSocketConfig : AbstractSessionWebSocketMessageBrokerConfigurer<Session>() {
    override fun configureStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/messages").withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker("/queue/", "/topic/")
        registry.setApplicationDestinationPrefixes("/app")
    }
}