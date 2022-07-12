package com.example.springBootRedisExample.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

// @EnableCaching: 启用缓存功能，默认情况下，Spring Boot 会自动启用缓存，但是如果你想自己控制缓存，可以使用 @EnableCaching 注解。
// 緩存功能可以提高查詢數據的效能，因為 Redis 的數據是全局的，所以只要查詢一次，就會把數據缓存起來，下次再查詢時，
// 就不用再次查詢數據庫，而是直接把缓存中的數據返回。

@Configuration
@EnableCaching//開啟快取
public class RedisConfig extends CachingConfigurerSupport {

// CacheManager 的配置，這裡的配置是用來管理緩存的
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager rm = RedisCacheManager.create(connectionFactory);
        /*rm.setDefaultExpiration(30L);// 设置缓存时间*/
        return rm;
    }
// RedisTemplate 的配置，這裡的配置是用來管理緩存的，RedisTemplate 是 Spring Boot 提供的一個操作 Redis 的模板，
// 它可以操作 String、Hash、List、Set、ZSet、Bitmap 等等，其中 String 的是 String 的值，Hash 的是 Hash 的值，
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

}
