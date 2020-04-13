package com.power.fast.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fei
 * @title: DruidConfig
 * @projectName power-fast
 * @description: MybatisPlus分页插件
 * @date 2020/04/06 18:05
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 开启驼峰 ConfigurationCustomizer ：定制配置类，修改Mybatis一些配置
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //开启驼峰转换
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
