package com.example.redis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "Person")
public class Person {
    @Id
    @Indexed
    private int id;
    private String name;
    private String mobile;
    private String email;
    private long personalRate;


}
