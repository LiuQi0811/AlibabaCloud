package org.xr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiuQi
 * @version 1.0
 * @data ${DATE} ${TIME}
 */
@SpringBootApplication
@MapperScan(value = "org.xr.item.mapper")
public class ItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }
}