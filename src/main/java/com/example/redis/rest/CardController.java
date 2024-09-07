package com.example.redis.rest;

import com.example.redis.entity.Person;
import com.example.redis.service.CardService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/card")
public class CardController {


    private final CardService cardService;

    public CardController(RedisTemplate<String, Object> redisTemplate, CardService cardService) {
        this.redisTemplate = redisTemplate;
        this.cardService = cardService;
    }

    @PostMapping("/save")
    public Person addPerson(@RequestBody Person person){
    cardService.save(person.getId());

    }

    @PostMapping("/get-all")
    public Person addPerson(@RequestBody Person person){
        Object objectList = redisTemplate.opsForList().leftPop("personList");
        return objectList;
    }
}
