package com.huangzh.userservice.feign;

import com.huangzh.userservice.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

/**
 * 远程调用订单服务
 */
@FeignClient(name = "order-service")
public interface OrderFeignClient {

    /**
     * 创建订单
     */
    @GetMapping("/create")
    Result createOrder(String userId, String commodityCode, int orderCount);

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime());
    }
}
