package com.lt.edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * ClassName: EduConfig
 * Description:
 * date: 2020/5/16 19:01
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Configuration
@MapperScan("com.lt.edu.mapper") //dao层扫描
@ComponentScan("com.lt.config") //全局配置类扫描
@EnableDiscoveryClient  //开启注册中心
@EnableFeignClients(basePackages = "com.lt.edu.client")    //开启feign
@EnableCaching //开启缓存
public class EduConfig {
    /**
     * Mybatis-plus的逻辑删除插件
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 实体类验证
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }

}
