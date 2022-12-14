package org.xr.user.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 13:47
 * 读取配置信息
 */
@Component
@Data
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties
{
    private String dateformat;
    private String envSharedValue;
}
