package com.huangzh.userservice.single;

/**
 * 枚举实现单例模式-优雅
 *
 * @author: night-wind
 * @Date: 2021/4/20 12:55
 */
public enum SingletonEnum {

    INSTANCE;

    public void doSomething(){
        System.out.println("执行单例的方法一次");
    }


    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                SingletonEnum.INSTANCE.doSomething();
            }).start();
        }



    }
}
