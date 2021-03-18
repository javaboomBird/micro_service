package com.huangzh.orderservice.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class Demo02Message implements Serializable {

    // 队列
    public static final String QUEUE = "QUEUE_DEMO_02";

    // 交换器
    public static final String EXCHANGE = "EXCHANGE_DEMO_02";

    // 路由
    public static final String ROUTING_KEY = "#.yu.nai";

    /**
     * 编号
     */
    private Integer id;
}
