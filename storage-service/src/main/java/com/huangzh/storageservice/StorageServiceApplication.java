package com.huangzh.storageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.huangzh.storageservice.mapper")
@SpringBootApplication
public class StorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceApplication.class, args);
    }

}
