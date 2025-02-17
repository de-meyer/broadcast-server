package com.cli.fancy.broadcastserver

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/redis")
class RedisController(private val redisService: RedisService) {

    @PostMapping("/save")
    fun saveData(@RequestParam key: String, @RequestParam value: String): ResponseEntity<String> {
        redisService.saveData(key, value)
        return ResponseEntity.ok("Data saved successfully")
    }

    @GetMapping("/get")
    fun getData(@RequestParam key: String): ResponseEntity<String> {
        val value = redisService.getData(key)
        return if (value != null) {
            ResponseEntity.ok(value)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found")
        }
    }
}