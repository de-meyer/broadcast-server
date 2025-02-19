package com.cli.fancy.broadcastserver

class HelloMessage (private var name: String) {
    fun getName(): String {
        return name
    }
    fun setName(name: String) {
        this.name = name
    }
    override fun toString(): String {
        return "HelloMessage(name='$name')"
    }
}