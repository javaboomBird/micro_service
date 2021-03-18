package com.huangzh.orderservice.model;

import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Accessors(chain = true)
@Data
@Table(name = "order_table")
public class OrderTable implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "commodity_code")
    private String commodityCode;

    @Column(name = "`count`")
    private Integer count;

    @Column(name = "money")
    private BigDecimal money;
}