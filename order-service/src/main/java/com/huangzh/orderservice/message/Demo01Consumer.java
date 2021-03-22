package com.huangzh.orderservice.message;


import com.huangzh.orderservice.model.OrderTable;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = Demo01Message.QUEUE)
public class Demo01Consumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo01Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

    @RabbitHandler
    public void onMessage1(OrderTable order, Channel channel, Message message) throws IOException {
        logger.info("[自定义消息消费成功][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), order);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        logger.info("小富收到消息：{}", message.getMessageProperties().getDeliveryTag());
    }
}
