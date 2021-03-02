package com.huangzh.gateway;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GatewayApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redis连接测试
     */
    @Test
    void redisTest() {
        stringRedisTemplate.opsForValue().set("yunai", "shuai");
        System.out.println(stringRedisTemplate.opsForValue().get("yunai"));
    }

}
