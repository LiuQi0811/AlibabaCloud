package org.xr.item.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xr.item.pojo.Item;
import org.xr.item.pojo.ItemStock;

/**
 * @author LiuQi
 * @version 1.0
 */
@Configuration
@Slf4j
public class CaffeineConfig {
    @Bean
    public Cache<Long, Item> itemCache() {
        log.info("商品缓存");
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(10_000)
                .build();
    }

    @Bean
    public Cache<Long, ItemStock> itemStockCache() {
        log.info("商品库存缓存");
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(10_000)
                .build();
    }


}
