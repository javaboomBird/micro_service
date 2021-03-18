package com.huangzh.storageservice.mapper;

import com.huangzh.storageservice.model.StorageTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface StorageTableMapper extends Mapper<StorageTable> {

    /**
     * 根据商品编号扣除库存
     */
    void deduct(@Param("commodityCode") String commodityCode, @Param("count") int count);
}