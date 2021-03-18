package com.huangzh.userservice.model;

import javax.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Table(name = "user_info")
public class UserInfo {


    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "money")
    private BigDecimal money;
}