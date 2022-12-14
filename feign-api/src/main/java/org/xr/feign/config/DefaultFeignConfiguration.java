package org.xr.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 10:01
 * Feign 日志配置类
 * 而日志的级别分为四种：
 * - NONE：不记录任何日志信息，这是默认值。
 * - BASIC：仅记录请求的方法，URL以及响应状态码和执行时间
 * - HEADERS：在BASIC的基础上，额外记录了请求和响应的头信息
 * - FULL：记录所有请求和响应的明细，包括头信息、请求体、元数据。
 *
 * 如果要**全局生效**，将其放到启动类的@EnableFeignClients这个注解中：
 * @EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class)
 * 如果是**局部生效**，则把它放到对应的@FeignClient这个注解中
 * @EnableFeignClients(clients = UserServiceClient.class,defaultConfiguration = DefaultFeignConfiguration.class)
 */
public class DefaultFeignConfiguration
{
    @Bean
    public Logger.Level loggerLevel(){
        return Logger.Level.BASIC;
    }
}
