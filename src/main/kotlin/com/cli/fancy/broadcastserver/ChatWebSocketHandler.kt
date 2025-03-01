package com.cli.fancy.broadcastserver

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketSession

@Component
class ChatWebSocketHandler : WebSocketHandler {
    private val sessions = mutableSetOf<WebSocketSession>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.add(session)
        session.sendMessage(TextMessage("Connected to WebSocket Server"))
    }

    override fun handleMessage(session: WebSocketSession, message: org.springframework.web.socket.WebSocketMessage<*>) {
        val receivedText = message.payload.toString()
        println("Received: $receivedText")
        // Broadcast message to all clients
        sessions.forEach { it.sendMessage(TextMessage("Client says: $receivedText")) }
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        println("WebSocket error: ${exception.message}")
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessions.remove(session)
        println("Client disconnected")
    }

    override fun supportsPartialMessages(): Boolean = false
}