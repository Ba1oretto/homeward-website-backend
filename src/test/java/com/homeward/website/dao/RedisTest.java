package com.homeward.website.dao;

import com.google.gson.Gson;
import com.homeward.website.bean.PO.ItemCart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
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

    @Test
    void testHashPutIfAbsent() {
        // redisTemplate.opsForHash().putIfAbsent("ItemCart", "1ae541e990d340798a2077525b752d2c",
        //         new ItemCart().setId("1ae541e990d340798a2077525b752d2c").setAmount(1).setName("Spring Crate Key").setCategory("crate").setPrice(599).setDiscount(false).setDiscountPercent(100));
        redisTemplate.opsForHash().putIfAbsent("Ba1oretto", "1ae541e990d340798a2077525b75233c", 2);
    }

    @Test
    void testHashGet1() {
        System.out.println(redisTemplate.opsForHash().get("Ba1oretto", "1ae541e990d340798a2077525b752d2c") instanceof Integer);
    }
    @Test
    void testHashGet2() {
        System.out.println(redisTemplate.opsForValue().get("619377de9ada41388ef93dbf9fe56320"));
    }

    @Test
    void testHashHasKey() {
        Boolean itemCart = redisTemplate.opsForHash().hasKey("Ba1oretto", "1ae541e990d340798a2077525b752d2c");
        System.out.println(itemCart);
    }

    @Test
    void testHashHasKeys() {
        System.out.println(redisTemplate.opsForHash().keys("Ba1oretto").size());
    }

    @Test
    void testHashHasEntries() {
        Map<Object, Object> map = redisTemplate.opsForHash().entries("Ba1oretto");
        Gson gson = new Gson();
        System.out.println(gson.toJson(map));
    }
}
