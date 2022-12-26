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
@MapperScan(value = "org.xr.account.mapper")
public class AccountServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServerApplication.class,args);
    }
}