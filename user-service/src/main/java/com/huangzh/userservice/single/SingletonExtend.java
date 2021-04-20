package com.huangzh.userservice.single;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 容器管理实现单例模式
 *
 * @author: night-wind
 * @Date: 2021/4/20 12:55
 */
public class SingletonExtend {

    private static final ConcurrentHashMap<String,SingletonExtend> map= new ConcurrentHashMap<>();

    private static final ReentrantLock lock = new ReentrantLock();

    private SingletonExtend() {
        System.out.println("实例化singleton一次");
    }

    public static SingletonExtend getInstance(){
        lock.lock();
        SingletonExtend singleton;
        try {
            singleton = map.get("singleton");
            if (singleton == null) {
                map.put("singleton", singleton=new SingletonExtend());
            }
        } finally {
            lock.unlock();
        }

        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            // 测试多线程容器单例
            new Thread(() -> {
                System.out.println(SingletonExtend.getInstance());
            }).start();

            // 测试单线程容器单例
//            System.out.println(SingletonExtend.getInstance());
        }


    }
}
