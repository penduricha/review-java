package com.example.spring_redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;
// Serializer chính bạn đang tìm


// Các serializer bổ trợ cho Key
import org.springframework.data.redis.serializer.*;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import java.time.Duration;

@Configuration
@EnableCaching
// 1. THÊM DÒNG NÀY: Trỏ đúng đến package chứa Repository của bạn
@EnableRedisRepositories(basePackages = "com.example.spring_redis.cachings")
public class RedisConfig {

    private final DotenvConfig dotenvConfig = new DotenvConfig();

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(dotenvConfig.dotenv().get("REDIS_HOST"));
        config.setPort(Integer.parseInt(dotenvConfig.dotenv().get("REDIS_PORT")));

        // Kiểm tra xem biến môi trường có null không trước khi parse
        String dbIndex = dotenvConfig.dotenv().get("REDIS_DBS");
        config.setDatabase(dbIndex != null ? Integer.parseInt(dbIndex) : 0);

        config.setUsername(dotenvConfig.dotenv().get("REDIS_USERNAME"));
        config.setPassword(RedisPassword.of(dotenvConfig.dotenv().get("REDIS_PASS")));

        return new JedisConnectionFactory(config);
    }

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        StringRedisSerializer stringSerializer = new StringRedisSerializer();
//        GenericJackson2JsonRedisSerializer jacksonSerializer = new GenericJackson2JsonRedisSerializer();
//
//        template.setKeySerializer(stringSerializer);
//        template.setHashKeySerializer(stringSerializer);
//        template.setValueSerializer(jacksonSerializer);
//        template.setHashValueSerializer(jacksonSerializer);
//
//        template.afterPropertiesSet();
//        return template;
//    }
//
//    // 2. QUAN TRỌNG: Cấu hình này giúp Repository hoạt động (Thay thế cho redisKeyValueTemplate ngầm định)
//    @Bean
//    public RedisKeyValueAdapter redisKeyValueAdapter(RedisTemplate<String, Object> redisTemplate) {
//        return new RedisKeyValueAdapter(redisTemplate);
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofHours(1))
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//
//        return RedisCacheManager.builder(connectionFactory)
//                .cacheDefaults(config)
//                .build();
//    }
}