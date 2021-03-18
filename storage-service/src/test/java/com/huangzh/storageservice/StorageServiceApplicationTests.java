package com.huangzh.storageservice;

import com.huangzh.storageservice.mapper.StorageTableMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StorageServiceApplicationTests {

    @Autowired
    private StorageTableMapper storageTableMapper;

    @Test
    void contextLoads() {
        System.out.println(storageTableMapper.selectAll());
    }

}
