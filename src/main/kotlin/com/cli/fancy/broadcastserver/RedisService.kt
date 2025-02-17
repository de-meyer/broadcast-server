package com.cli.fancy.broadcastserver

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisService(private val redisTemplate: RedisTemplate<String, String>) {

    fun saveData(key: String, value: String) {
        redisTemplate.opsForValue().set(key, value)
    }

    fun getData(key: String): String? {
        return redisTemplate.opsForValue().get(key)
    }
}