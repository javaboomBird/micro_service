package com.huangzh.userservice.feign;


import com.huangzh.userservice.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 库存服务
 */
@FeignClient("storage-service")
public interface StorageFeignClient {

    /**
     * 扣减库存
     */
    @GetMapping("/deduct")
    Result deduct(String commodityCode, int count);


}
