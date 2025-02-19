package com.cli.fancy.broadcastserver

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils
import kotlin.concurrent.thread

@Controller
class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    fun greeting(message: HelloMessage): GreetingMessage {
        Thread.sleep(1000) // simulated delay
        return GreetingMessage("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!")
    }
}