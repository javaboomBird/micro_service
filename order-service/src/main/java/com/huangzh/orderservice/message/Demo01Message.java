package com.huangzh.orderservice.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class Demo01Message implements Serializable {

    // 队列
    public static final String QUEUE = "QUEUE_DEMO_01";

    // 交换器
    public static final String EXCHANGE = "EXCHANGE_DEMO_01";

    // 路由
    public static final String ROUTING_KEY = "ROUTING_KEY_01";

    /**
     * 编号
     */
    private Integer id;
}
