package com.huangzh.orderservice.controller;


import com.huangzh.orderservice.mapper.OrderTableMapper;
import com.huangzh.orderservice.model.OrderTable;
import com.huangzh.orderservice.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order/")
public class OrderController {

    @Autowired
    private OrderTableMapper mapper;

    private static int data = 0;


    /**
     * 创建订单
     */
    @GetMapping("create")
    public Result create(String userId, String commodityCode, int orderCount) {
        mapper.insert(new OrderTable().setUserId(userId).setCommodityCode(commodityCode).setCount(orderCount));
        return Result.success();
    }

    public static void main(String[] args) throws InterruptedException {
        OrderTable a = new OrderTable().setUserId("a");
        OrderTable b = new OrderTable().setUserId("b");
        System.out.println("交换前"+a.getUserId()+b.getUserId());
        swap(a, b);
        System.out.println("交换后"+a.getUserId()+b.getUserId());


    }

    public static void swap(OrderTable a,OrderTable b){
//        OrderTable tmp = a;
//        a = b;
//        b = tmp;
        String ida = a.getUserId();
        String idb = b.getUserId();
        a.setUserId(idb);
        b.setUserId(ida);
    }

}
