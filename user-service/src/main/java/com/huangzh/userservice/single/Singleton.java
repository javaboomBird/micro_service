package com.huangzh.userservice.single;

/**
 * 静态内部类实现单例模式-优雅
 *
 * @author: night-wind
 * @Date: 2021/4/20 12:55
 */
public class Singleton {

    private Singleton() {
        System.out.println("实例化singleton一次");
    }



    public static Singleton getInstance(){
        return SingleHolder.singleton;
    }

    // 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
    private static class SingleHolder{
        private static Singleton singleton = new Singleton();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                Singleton instance = Singleton.getInstance();
            }).start();
        }



    }
}
