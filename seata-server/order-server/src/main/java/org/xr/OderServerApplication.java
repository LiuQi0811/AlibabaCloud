package org.xr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LiuQi
 * @version 1.0
 * @data ${DATE} ${TIME}
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan(value = "org.xr.order.mapper")
public class OderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OderServerApplication.class,args);

    }
}