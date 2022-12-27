package org.xr.item.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Test;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/27 8:43
 */
public class TestDemo {
    @Test
    public void testBasicOps(){
        Cache<String, String> cache = Caffeine.newBuilder().build(); //构建cache对象
        cache.put("dlrb","迪丽热巴");//储存数据
        String dlrb = cache.getIfPresent("dlrb");//取数据
        System.out.println(dlrb);
        // 取数据，包含两个参数：
        // 参数一：缓存的key
        // 参数二：Lambda表达式，表达式参数就是缓存的key，方法体是查询数据库的逻辑
        // 优先根据key查询JVM缓存，如果未命中，则执行参数二的Lambda表达式
        String defaultGF = cache.get("defaultGF", key -> {
            return "吴忧"; // 根据key去数据库查询数据
        });
        System.out.println(defaultGF);
    }



}
