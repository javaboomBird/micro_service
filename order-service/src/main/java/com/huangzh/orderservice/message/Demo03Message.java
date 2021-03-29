package com.huangzh.orderservice.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: night-wind
 * @Date: 2021/3/18 21:55
 */
@Data
public class Demo03Message implements Serializable {

    public static final String QUEUE_A = "QUEUE_DEMO_03_A";
    public static final String QUEUE_B = "QUEUE_DEMO_03_B";

    public static final String EXCHANGE = "EXCHANGE_DEMO_03";

    /**
     * 编号
     */
    private Integer id;
}
