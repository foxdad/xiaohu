package com.lt.oss.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: config
 * Description:
 * date: 2020/5/24 14:46
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Configuration
@ComponentScan("com.lt.config")//全局配置导入
@EnableDiscoveryClient//开启注册中心配置
public class OssSwaggerConfig {

}
