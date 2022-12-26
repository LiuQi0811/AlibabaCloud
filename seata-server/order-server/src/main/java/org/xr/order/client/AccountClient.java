package org.xr.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author LiuQi
 */
@FeignClient(value = "account-service")
public interface AccountClient {

    /**
     * 扣除余额
     * @param userId
     * @param money
     */
    @PutMapping("/account/{userId}/{money}")
    void deduct(@PathVariable("userId") String userId, @PathVariable("money") Integer money);
}
