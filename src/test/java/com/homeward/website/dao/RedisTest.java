package com.homeward.website.dao;

import com.google.gson.Gson;
import com.homeward.website.bean.PO.ItemCart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;

import java.util.ArrayList;
import java.util.List;
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
        // redisTemplate.opsForHash().putIfAbsent("ItemCart", "985301e101274d66844dc41bc751cc2c",
        //         new ItemCart().setId("985301e101274d66844dc41bc751cc2c").setAmount(5).setName("Spring Crate Key").setCategory("crate").setPrice(2399).setDiscount(false).setDiscountPercent(100));
        redisTemplate.opsForHash().putIfAbsent("Ba1oretto", "985301e101274d66844dc41bc751cc2c", 2);
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
    void testHashHasEntries1() {
        Map<Object, Object> map = redisTemplate.opsForHash().entries("Ba1oretto");
        Gson gson = new Gson();
        System.out.println(gson.toJson(map));
    }

    @Test
    void testHashHasEntries2() {
        List<ItemCart> list = new ArrayList<>();
        Map<Object, Object> entries = redisTemplate.opsForHash().entries("Ba1oretto");
        entries.forEach((k, v) -> {
            ItemCart itemCart = (ItemCart) redisTemplate.opsForHash().get("ItemCart", k);
            assert itemCart != null;
            itemCart.setInCart(Long.parseLong(v + ""));
            list.add(itemCart);
        });
        list.forEach(System.out::println);
    }

    @Test
    void testHashHasDelete1() {
        Boolean ba1oretto = redisTemplate.delete("Ba1oretto");
        assert ba1oretto;
        // redisTemplate.opsForHash()
    }

    @Test
    void testHashHasDelete2() {
        System.out.println(redisTemplate.opsForHash().delete("Ba1oretto", "1ae541e990d340798a2077525b752d2c"));
    }
}
