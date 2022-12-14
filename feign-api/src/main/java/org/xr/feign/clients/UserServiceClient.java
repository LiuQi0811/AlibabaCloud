package org.xr.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xr.feign.entity.User;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 9:49
 */
@FeignClient(value = "user-service")
public interface UserServiceClient {
    @RequestMapping(value = "/user/{id}")
    User queryById(@PathVariable("id") Long id);
}
