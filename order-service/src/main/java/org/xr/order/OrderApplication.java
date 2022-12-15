package org.xr.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.xr.feign.clients.UserServiceClient;
import org.xr.feign.config.DefaultFeignConfiguration;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 8:41
 */
@MapperScan(value = "org.xr.order.mapper")
@SpringBootApplication
@EnableFeignClients(clients = UserServiceClient.class,defaultConfiguration = DefaultFeignConfiguration.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
