package com.yhb.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhb.storage.dte.Storage;

public interface StorageService extends IService<Storage> {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);

}
