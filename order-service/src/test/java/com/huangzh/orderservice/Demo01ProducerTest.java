package com.huangzh.orderservice;

import com.huangzh.orderservice.message.Demo01Producer;
import com.huangzh.orderservice.model.OrderTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceApplication.class)
public class Demo01ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo01Producer producer;

    /**
     * 自定义消息发送
     */
    @Test
    public void testMyMQ() throws InterruptedException {
        OrderTable order=new OrderTable().setCommodityCode("1cnm").setCount(50).setMoney(BigDecimal.valueOf(100)).setUserId("123");
        producer.sendMessage(order);
        logger.info("[testSyncSend][发送自定义消息：[{}] 发送成功]", Thread.currentThread().getName());
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    /**
     * 多线程发消息
     */
    @Test
    public void testMyMQConcurrent() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 100000; i++) {
            threadPool.submit(() -> {
                OrderTable order=new OrderTable().setCommodityCode("1cnm").setCount(50).setMoney(BigDecimal.valueOf(100)).setUserId("123").setId((int) System.currentTimeMillis());
                producer.sendMessage(order);
                logger.info("[testSyncSend][发送自定义消息：[{}] 发送成功]", Thread.currentThread().getName());
            });
        }

        // 阻塞等待，保证消费
        new CountDownLatch(100000).await();
    }

    @Test
    public void testSyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id);
        logger.info("[testSyncSend][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void tesSyncSendDefault() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSendDefault(id);
        logger.info("[tesSyncSendDefault][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testAsyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.asyncSend(id).addCallback(new ListenableFutureCallback<Void>() {

            @Override
            public void onFailure(Throwable e) {
                logger.info("[testASyncSend][发送编号：[{}] 发送异常]]", id, e);
            }

            @Override
            public void onSuccess(Void aVoid) {
                logger.info("[testASyncSend][发送编号：[{}] 发送成功，发送成功]", id);
            }

        });
        logger.info("[testASyncSend][发送编号：[{}] 调用完成]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
