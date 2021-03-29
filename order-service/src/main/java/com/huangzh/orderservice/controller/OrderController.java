package com.huangzh.orderservice.controller;


import com.huangzh.orderservice.mapper.OrderTableMapper;
import com.huangzh.orderservice.model.OrderTable;
import com.huangzh.orderservice.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Slf4j
@RestController
@RequestMapping("order/")
public class OrderController {

    @Autowired
    private OrderTableMapper mapper;

    private static int data = 0;


    /**
     * 创建订单
     */
    @GetMapping("create")
    public Result create() {
//        mapper.insert(new OrderTable().setUserId(userId).setCommodityCode(commodityCode).setCount(orderCount));
        log.info("生成订单");
        return Result.success();
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(200);


        for (int i = 0; i < 200; i++) {

            new Thread(() -> {
                data++;
                System.out.println("打工人" + data + "号准备就绪,当前的线程为" + Thread.currentThread().getName());
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println("当前的线程为:" + Thread.currentThread().getName() + "当前的data值为:" + data);

    }
}
