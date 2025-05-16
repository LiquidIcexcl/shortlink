package org.liquidice.shortlink.admin.config;

import feign.RequestInterceptor;
import org.liquidice.shortlink.admin.common.biz.user.UserContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenFeign 微服务调用传递用户信息配置
 *
 */
@Configuration
public class OpenFeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // 传递用户信息
            requestTemplate.header("username", UserContext.getUsername());
            requestTemplate.header("userId", String.valueOf(UserContext.getUserId()));
            requestTemplate.header("realName", String.valueOf(UserContext.getRealName()));
        };
    }
}
