package com.huangzh.orderservice.controller;

import com.huangzh.orderservice.model.OrderTable;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.math.BigDecimal;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JvmDemo {


    private static final AtomicInteger data=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        // 阿里禁止使用Executors创建线程池,堆积的请求处理队列可能会耗费非常大的内存，甚至OOM
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        //要使用带有ThreadFactory参数的ThreadPoolExecutor构造方法哦，这样你就可以方便的设置线程名字啦。
        CustomizableThreadFactory customizableThreadFactory = new CustomizableThreadFactory("自定义线程持");

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(5, 15, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(20),customizableThreadFactory);


        threadPoolExecutor.submit(()->{for (int i = 0; i < 10000; i++) {
            OrderTable order = new OrderTable().setCommodityCode("1cnm").setCount(50).setMoney(BigDecimal.valueOf(100)).setUserId("123").setId((int) System.currentTimeMillis());
            data.incrementAndGet();
            System.out.println(data.get() + "线程名称" + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }});


    }
}
