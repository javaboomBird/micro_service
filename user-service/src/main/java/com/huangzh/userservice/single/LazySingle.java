package com.huangzh.userservice.single;

/**
 * 简单的懒汉式单例模式
 * 多线程下会导致单例创建失败
 * @author: night-wind @Date: 2021/4/20 11:35
 */
public class LazySingle {

    private static LazySingle hungrySingle;

    private LazySingle() {
        System.out.println("生成LazySingleton实例一次！");
    }

    public static LazySingle getSingle() {

        if (hungrySingle == null) {
            hungrySingle = new LazySingle();
        }

        return hungrySingle;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                LazySingle single = LazySingle.getSingle();
            }).start();
        }
    }
}
