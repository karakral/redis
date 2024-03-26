package com.example.redis;

import jdk.javadoc.doclet.Doclet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
		System.out.printf("Lets enjoy redis project");
	}



}
