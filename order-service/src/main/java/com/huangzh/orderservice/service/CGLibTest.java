package com.huangzh.orderservice.service;

import org.springframework.cglib.proxy.Enhancer;

/**
 * cglib动态代理测试
 * @author GaiYa
 */
public class CGLibTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGlibService.class);
        enhancer.setCallback(new MyMethodInterceptor());
        CGlibService proxy = (CGlibService) enhancer.create();
        proxy.cnm("茄子");


    }

}
