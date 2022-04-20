package com.homeward.website.raw;

import com.homeward.website.util.JwtUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

public class SimpleTest {
    @Test
    void testJWT() {
        String token1 = JwtUtils.createToken("619377de9ada41388ef93dbf9fe56320");
        String token2 = JwtUtils.createToken("619377de9ada41388ef93dbf9fe56320");
        System.out.println(token1.equals(token2));
    }

    @Test
    void testIterator() {
        String[] strings = {"1", "2", "3", "4"};
        Iterator<String> stringIterator = Arrays.stream(strings).iterator();
        stringIterator.forEachRemaining(System.out::println);
    }

    @Test
    void testUUID() {
        System.out.println(UUID.randomUUID().toString().replaceAll("(.*?)-.*", "$1"));
        for (int i = 0; i < 4; i++) {
            System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        }
    }
}
