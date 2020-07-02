package com.lt.vedio.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: VedioConfig
 * Description:
 * date: 2020/6/7 18:12
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Configuration
@ComponentScan("com.lt.config")//全局配置导入
@EnableDiscoveryClient//开启注册中心配置
@EnableFeignClients(basePackages = "com.lt.vedio.client")
public class VedioConfig {

}
