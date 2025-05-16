package org.liquidice.shortlink.project.config;

import lombok.RequiredArgsConstructor;
import org.liquidice.shortlink.project.common.biz.user.UserTransmitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 用户配置自动装配
 */
@Configuration(value="userConfigurationByProject")
@RequiredArgsConstructor
public class UserConfiguration implements WebMvcConfigurer {

    private final UserTransmitInterceptor usertransmitInterceptor;

    /**
     * 用户消息传递过滤器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(usertransmitInterceptor)
                .addPathPatterns("/**");
    }

}
