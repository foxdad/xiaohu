package com.lt.cms.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: CmsConfig
 * Description:
 * date: 2020/6/9 11:28
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Configuration
@MapperScan("com.lt.cms.mapper") //dao层扫描
@ComponentScan("com.lt.config") //全局配置类扫描
@EnableDiscoveryClient //nacos启动
@EnableCaching //开启缓存
public class CmsConfig {
    /**
     * Mybatis-plus的逻辑删除插件
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
