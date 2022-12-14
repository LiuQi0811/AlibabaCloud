package org.xr.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 16:59
 * 自定义全局过滤器
 * 需求：定义全局过滤器，拦截请求，判断请求的参数是否满足下面条件：
 * <p>
 * - 参数中是否有authorization，
 * <p>
 * - authorization参数值是否为admin
 * <p>
 * 如果同时满足则放行，否则拦截
 *
 *
 * 排序的规则是什么呢？
 *
 * - 每一个过滤器都必须指定一个int类型的order值，**order值越小，优先级越高，执行顺序越靠前**。
 * - GlobalFilter通过实现Ordered接口，或者添加@Order注解来指定order值，由我们自己指定
 * - 路由过滤器和defaultFilter的order由Spring指定，默认是按照声明顺序从1递增。
 * - 当过滤器的order值一样时，会按照 defaultFilter > 路由过滤器 > GlobalFilter的顺序执行
 */
@Order(-1)
@Component
@Slf4j
public class AuthorizeFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求参数
        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
        log.info("获取请求参数 {}", params);
        // 获取authorization参数
        String auth = params.getFirst("authorization");
        // 校验
        if ("admin".equals(auth)) {
            //放行
            return chain.filter(exchange);
        }
        // 拦截
        // 禁止访问，设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        // 结束处理
        return exchange.getResponse().setComplete();
    }
}
