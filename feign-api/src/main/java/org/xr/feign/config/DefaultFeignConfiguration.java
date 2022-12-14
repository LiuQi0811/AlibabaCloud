package org.xr.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 10:01
 */
public class DefaultFeignConfiguration
{
    @Bean
    public Logger.Level loggerLevel(){
        return Logger.Level.BASIC;
    }
}
