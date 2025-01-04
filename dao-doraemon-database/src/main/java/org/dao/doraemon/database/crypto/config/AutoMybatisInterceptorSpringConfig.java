package org.dao.doraemon.database.crypto.config;

import org.dao.doraemon.database.crypto.processor.ConfigInterceptorBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 当加解密插件是通过jar包利用springboot的自动装配的提供方式时，不修改原项目中的 SqlSessionFactory 配置，
 * 那么可以通过以下方式动态加入
 *
 * @author wuzhenhong
 * @date 2024/12/27 10:28
 */
@Configuration
public class AutoMybatisInterceptorSpringConfig {

    @Bean
    public ConfigInterceptorBeanPostProcessor configInterceptorBeanPostProcessor() {
        return new ConfigInterceptorBeanPostProcessor();
    }
}
