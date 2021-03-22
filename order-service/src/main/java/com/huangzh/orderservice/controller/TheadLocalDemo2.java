package com.huangzh.orderservice.controller;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author GaiYa
 */
public class TheadLocalDemo2 {

    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final ThreadLocal<Integer> threadId =
            ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) throws Exception {
        RunnableTask task = new RunnableTask();
        new Thread(task, "A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(task, "B").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(task, "C").start();
        TimeUnit.SECONDS.sleep(1);
    }

    static class RunnableTask implements Runnable {
        @Override
        public void run() {
            try {
                threadId.set(new Random().nextInt(10));
                System.out.println(Thread.currentThread().getName() + "---------------------" +
                        threadId.get());
            } finally {
                threadId.remove();
            }
        }
    }
}
