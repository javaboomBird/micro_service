package com.huangzh.userservice.controller;

import com.huangzh.userservice.dto.UserDTO;
import com.huangzh.userservice.feign.OrderFeignClient;
import com.huangzh.userservice.feign.StorageFeignClient;
import com.huangzh.userservice.result.Result;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author huangzh
 * @date 2021/3/2
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private static AtomicInteger data = new AtomicInteger(0);
    private static int a = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    // 读锁
    private final Lock readLock = lock.readLock();
    // 写锁
    private final Lock writeLock = lock.writeLock();

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Autowired
    private StorageFeignClient storageFeignClient;




    @GetMapping("/{id}")
    public UserDTO get(@PathVariable String id) {
        return new UserDTO("帅哥", 18);
    }

    /**
     * 从用户账户中借出扣除金额
     */
    public void debit(String userId, int money){

    }

    /**
     * 购买商品
     */
    @GlobalTransactional(rollbackFor = Exception.class) // 开启全局事务
    public Result purchase(String userId, String commodityCode, int orderCount){

        // 生成订单
        orderFeignClient.createOrder(userId, commodityCode, orderCount);
        // 用户扣费
        debit(userId, 0);
        // 减少库存
        storageFeignClient.deduct(commodityCode, orderCount);
        return Result.success();
    }
}
