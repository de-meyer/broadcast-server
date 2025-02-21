package com.cli.fancy.broadcastserver

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils
import kotlin.concurrent.thread

@Controller
class GreetingController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    fun greeting(message: String): String {
    return "message: $message"
    }
}