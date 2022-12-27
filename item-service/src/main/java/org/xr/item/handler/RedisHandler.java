package org.xr.item.handler;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.xr.item.pojo.Item;
import org.xr.item.pojo.ItemStock;
import org.xr.item.service.ItemService;
import org.xr.item.service.ItemStockService;

import java.util.List;

/**
 * @author LiuQi
 * @version 1.0
 */
@Component
@Slf4j
public class RedisHandler implements InitializingBean {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemStockService itemStockService;
    @Autowired
    private RedisTemplate redisTemplate;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean 实现方法");
        //初始化 缓存
        List<Item> items = itemService.list();//查询全部商品信息
        log.info("查询全部商品信息 {}", JSON.toJSON(items));

        for (Item item : items) { //放入缓存
            String json = MAPPER.writeValueAsString(item);  //item序列化为JSON
            log.info("item序列化为JSON {}", json);
            redisTemplate.opsForValue().set("item:id:" + item.getId(), json);//数据存入redis
        }
        List<ItemStock> itemStocks = itemStockService.list();
        log.info("查询商品库存全部信息 {}", JSON.toJSON(itemStocks));
        for (ItemStock itemStock : itemStocks) {//放入缓存
            String json = MAPPER.writeValueAsString(itemStock);
            log.info("itemStock序列化为JSON {}", json);
            redisTemplate.opsForValue().set("item:stock:id:" + itemStock.getId(), json);//数据存入redis
        }

    }

    public void saveItem(Item item) {
        try {
            String json = MAPPER.writeValueAsString(item);
            redisTemplate.opsForValue().set("item:id:" + item.getId(), json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteItemById(Long id) {
        redisTemplate.opsForValue().decrement("item:id:" + id);
    }
}
