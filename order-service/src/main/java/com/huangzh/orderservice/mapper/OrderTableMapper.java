package com.huangzh.orderservice.mapper;

import com.huangzh.orderservice.model.OrderTable;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderTableMapper extends Mapper<OrderTable> {
}