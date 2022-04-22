package com.homeward.website.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContainerStartAutoInitializing implements InitializingBean {
    private final RedisTemplate<String, Object> redisTemplate;

    public ContainerStartAutoInitializing(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // redisTemplate.opsForHash()
    }
}
