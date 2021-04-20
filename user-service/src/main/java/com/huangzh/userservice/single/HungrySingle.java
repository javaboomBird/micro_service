package com.huangzh.userservice.single;

/**
 * 饿汉式单例模式
 *
 * @author: night-wind @Date: 2021/4/20 11:35
 */
public class HungrySingle {

    private static final HungrySingle hungrySingle = new HungrySingle();

    private HungrySingle() {
        System.out.println("生成HungrySingle实例一次！");
    }

    public static HungrySingle getSingle() {
        return hungrySingle;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                HungrySingle single = HungrySingle.getSingle();
            }).start();
        }
    }
}
