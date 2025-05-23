package org.liquidice.shortlink.aggregation.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 演示环境配置属性
 */
@Data
@Component
@ConfigurationProperties(prefix="short-link.demo-mode")
public class DemoModeProperties {

    /**
     * 是否开启演示环境样式
     */
    private Boolean enable;

    /**
     * 演示环境黑名单路径
     */
    private List<String> blacklist;
}
