package com.huangzh.orderservice.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author GaiYa
 */
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Override
    public void say(String name) {
        log.info("你快说话啊"+name);
    }
}
