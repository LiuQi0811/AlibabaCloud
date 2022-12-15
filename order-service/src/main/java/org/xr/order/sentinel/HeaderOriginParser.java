package org.xr.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/15 12:49
 */
@Component
public class HeaderOriginParser implements RequestOriginParser
{

    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        //获取请求头
        String origin = httpServletRequest.getHeader("origin");
        // 非空判断
        if(StringUtils.isEmpty(origin))
        {
            origin = "blank";
        }
        return origin;
    }
}
