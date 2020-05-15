package com.yhb.feign.storage.fallback;

import com.yhb.common.base.Result;
import com.yhb.feign.storage.service.StorageServiceFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class StorageServiceFallbackFactory implements FallbackFactory<StorageServiceFeign> {


    @Override
    public StorageServiceFeign create(Throwable throwable) {
        return new StorageServiceFeign() {

            @Override
            public Result decrease(Long productId, Integer count) {
                return null;
            }
        };
    }
}
