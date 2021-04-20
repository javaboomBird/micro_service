package com.huangzh.userservice.single;

/**
 * 双重检查懒汉式单例模式
 *
 * @author: night-wind @Date: 2021/4/20 11:35
 */
public class DLCLazySingle {

    private static DLCLazySingle hungrySingle;

    private DLCLazySingle() {
        System.out.println("生成LazySingleton实例一次！");
    }

    public synchronized static DLCLazySingle getSingle() {

        /*
        第一层非空判断，是为了减少不必要的同步，假如其他线程已经创建资源了，也就是不需要每次都进入同步方法获取锁，消耗资源
        第二层非空判断，是为了让多个线程在最外层都判断为null，想生成实例的时候，保证只有一个实例生成
         */
        if (hungrySingle == null) {
            synchronized (DLCLazySingle.class) {
                if (hungrySingle == null) {
                    hungrySingle = new DLCLazySingle();
                }
            }
        }

        return hungrySingle;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                DLCLazySingle single = DLCLazySingle.getSingle();
            }).start();
        }
    }
}
