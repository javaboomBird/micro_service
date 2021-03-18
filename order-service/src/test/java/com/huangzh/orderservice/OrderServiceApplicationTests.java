package com.huangzh.orderservice;

import com.huangzh.orderservice.mapper.OrderTableMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceApplicationTests {


    @Autowired
    private OrderTableMapper mapper;


    @Test
    void contextLoads() {
        System.out.println(mapper.selectAll());
    }

}
