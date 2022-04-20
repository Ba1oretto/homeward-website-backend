package com.homeward.website.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testCreate() {
        redisTemplate.opsForValue().set("test", "1", 8, TimeUnit.SECONDS);
        System.out.println(redisTemplate.getExpire("test"));
    }
}
