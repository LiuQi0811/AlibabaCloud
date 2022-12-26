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
@MapperScan(value = "org.xr.storage.mapper")
public class StorageServerApplication {
    public static void main(String[] args){
        SpringApplication.run(StorageServerApplication.class,args);

    }
}