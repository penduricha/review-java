package com.example.spring_redis.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;

public class DotenvConfig {
    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().load();
    }
}