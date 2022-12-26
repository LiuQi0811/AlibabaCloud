package org.xr.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author LiuQi
 */
@FeignClient(value = "storage-service")
public interface StorageClient {
    /**
     * 扣除库存
     * @param code
     * @param count
     */
    @PutMapping("/storage/{code}/{count}")
    void deduct(@PathVariable("code") String code, @PathVariable("count") Integer count);
}
