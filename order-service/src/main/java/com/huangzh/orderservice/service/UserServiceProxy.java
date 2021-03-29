package com.huangzh.orderservice.service;

import lombok.extern.slf4j.Slf4j;

/**
 * 静态代理
 * @author GaiYa
 */
@Slf4j
public class UserServiceProxy implements IUserService {

    private UserServiceImpl userServiceImpl;

    public UserServiceProxy(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void add(String name) {
        log.info("开启事务");
        userServiceImpl.add(name);
        log.info("结束事务");
    }

    @Override
    public void remove(String name) {

    }

    public static void main(String[] args) {
        IUserService target = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy((UserServiceImpl) target);
        proxy.add("陈粒");
    }
}
