package com.homeward.website.base;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = "foo=bar")
@ActiveProfiles("test")
class SpringBootProfileTest {

    @Value("${foo}")
    String foo;

    @Test
    void test(){
        assertThat(foo).isEqualTo("bar");
    }
}