package com.cli.fancy.broadcastserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BroadcastServerApplication

fun main(args: Array<String>) {
    runApplication<BroadcastServerApplication>(*args)
}
