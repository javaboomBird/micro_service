package com.huangzh.userservice.single;

/**
 * 方法同步懒汉式单例模式
 * 缺点: 锁的粒度很大,多线程下严重阻塞
 * @author: night-wind @Date: 2021/4/20 11:35
 */
public class SafeLazySingle {

    private static SafeLazySingle hungrySingle;

    private SafeLazySingle() {
        System.out.println("生成LazySingleton实例一次！");
    }

    public synchronized static SafeLazySingle getSingle() {

        if (hungrySingle == null) {
            hungrySingle = new SafeLazySingle();
        }

        return hungrySingle;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                SafeLazySingle single = SafeLazySingle.getSingle();
            }).start();
        }
    }
}
