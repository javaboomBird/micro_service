package com.huangzh.orderservice.service;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理测试
 * @author GaiYa
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        IUserService target = new UserServiceImpl();
        IOrderService target1 = new OrderServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(target);
        MyInvocationHandler handler1 = new MyInvocationHandler(target1);
        //第一个参数是指定代理类的类加载器（我们传入当前测试类的类加载器）
        //第二个参数是代理类需要实现的接口（我们传入被代理类实现的接口，这样生成的代理类和被代理类就实现了相同的接口）
        //第三个参数是invocation handler，用来处理方法的调用。这里传入我们自己实现的handler
        IUserService proxyInstance = (IUserService) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(), target.getClass().getInterfaces(), handler);
        proxyInstance.add("你这个垃圾");
        proxyInstance.remove("你这个垃圾");

        IOrderService proxyInstance1 = (IOrderService) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(), target1.getClass().getInterfaces(), handler1);
        proxyInstance1.say("废物");
    }
}
