package com.yhb.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhb.storage.dte.Storage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface StorageMapper extends BaseMapper<Storage> {

    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
