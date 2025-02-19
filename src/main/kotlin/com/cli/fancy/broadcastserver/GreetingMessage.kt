package com.cli.fancy.broadcastserver

class GreetingMessage (private var content: String) {

    fun getContent(): String {
        return content
    }
    fun setContent(content: String) {
        this.content = content
    }
    override fun toString(): String {
        return "GreetingMessage(content='$content')"
    }
}