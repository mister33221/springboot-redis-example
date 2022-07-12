package com.example.springBootRedisExample.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {
// 什麼時候要用@Resource?
// 在某個類中，有一個屬性是 RedisTemplate，這個屬性是由 Spring 容器來管理的，所以這個屬性是可以直接取得的
    @Resource
    private RedisTemplate<String,Object> redisTemplate;


// ValueOperations 是一個操作值的類別，它可以用來存取 Redis 的值。
// opsForValue() 方法可以用來存取 Redis 的值。
    public void set(String key, Object value) {
        //更改在redis裡面檢視key編碼問題
        RedisSerializer redisSerializer =new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }

    public Object get(String key) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }



}
