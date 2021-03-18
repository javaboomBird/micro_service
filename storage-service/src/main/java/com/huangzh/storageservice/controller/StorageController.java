package com.huangzh.storageservice.controller;


import com.huangzh.storageservice.mapper.StorageTableMapper;
import com.huangzh.storageservice.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storage/")
public class StorageController {

    @Autowired
    private StorageTableMapper storageTableMapper;

    /**
     * 扣除存储数量
     */
    public Result deduct(String commodityCode, int count) {
        storageTableMapper.deduct(commodityCode, count);
        return Result.success();
    }
}
