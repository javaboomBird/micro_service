package com.huangzh.orderservice.service;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * jdk动态代理
 * @author GaiYa
 */
@Slf4j
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 被代理的对象,Object类型
     */
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("动态代理开始");
        Object invoke = method.invoke(target, args);
        log.info("动态代理结束");
        return invoke;
    }
}
