package com.yhb.feign.storage.service;

import com.yhb.common.base.Result;
import com.yhb.feign.storage.config.FeignConfig;
import com.yhb.feign.storage.fallback.StorageServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "storage-service", fallbackFactory = StorageServiceFallbackFactory.class,configuration = FeignConfig.class)
public interface StorageServiceFeign {

    /**
     * 扣减库存
     */
    @GetMapping(value = "/api/storage/decrease")
    Result decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
