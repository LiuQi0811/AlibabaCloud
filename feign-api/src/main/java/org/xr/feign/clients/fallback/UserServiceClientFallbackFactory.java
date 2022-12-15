package org.xr.feign.clients.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.xr.feign.clients.UserServiceClient;
import org.xr.feign.entity.User;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/15 10:48
 * 给FeignClient编写失败后的降级逻辑
 *
 * ①方式一：FallbackClass，无法对远程调用的异常做处理
 *
 * ②方式二：FallbackFactory，可以对远程调用的异常做处理，我们选择这种
 *
 *
 * FallbackFactory
 */
@Slf4j
public class UserServiceClientFallbackFactory implements FallbackFactory<UserServiceClient>
{

    @Override
    public UserServiceClient create(Throwable throwable) {
        return  new UserServiceClient() {
            @Override
            public User queryById(Long id) {
                log.error("查询用户异常", throwable);
                return new User();
            }
        };
    }
}
