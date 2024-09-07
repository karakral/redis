package com.example.redis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{

    private final String personKey = "personList";

    private final RedisTemplate<String, Object> redisTemplate;

    public CardServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(Long id) {
        redisTemplate.opsForList().rightPush(personKey, id);
    }

    @Override
    public Object getAll() {
        return redisTemplate.opsForList().leftPop(personKey);
    }
}
