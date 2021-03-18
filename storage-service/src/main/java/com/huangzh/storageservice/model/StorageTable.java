package com.huangzh.storageservice.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "storage_table")
public class StorageTable {


    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "commodity_code")
    private String commodityCode;

    @Column(name = "`count`")
    private Integer count;
}