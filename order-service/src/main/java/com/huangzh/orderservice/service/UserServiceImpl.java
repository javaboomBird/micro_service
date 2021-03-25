package com.huangzh.orderservice.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements IUserService {

    @Override
    public void add(String name) {
        log.info("新增"+name);
    }

    @Override
    public void remove(String name) {
        log.info("移除"+name);
    }
}
