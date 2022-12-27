package org.xr.item.handler;

import com.github.benmanes.caffeine.cache.Cache;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xr.item.pojo.Item;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * @author LiuQi
 * @version 1.0
 */

@Component
@CanalTable("tb_item")
public class ItemHandler implements EntryHandler<Item> {
    @Autowired
    private RedisHandler redisHandler;
    @Autowired
    private Cache<Long, Item> itemCache;

    @Override
    public void insert(Item item) {
        itemCache.put(item.getId(), item);// 写数据到JVM进程缓存
        redisHandler.saveItem(item); // 写数据到redis
    }

    @Override
    public void update(Item before, Item after) {
        itemCache.put(after.getId(), after);  // 写数据到JVM进程缓存
        redisHandler.saveItem(after);  // 写数据到redis
    }

    @Override
    public void delete(Item item) {
        itemCache.invalidate(item.getId()); // 删除数据到JVM进程缓存
        redisHandler.deleteItemById(item.getId()); // 删除数据到redis
    }
}
