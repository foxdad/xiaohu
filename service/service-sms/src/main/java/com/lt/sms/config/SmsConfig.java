package com.lt.sms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: SmsConfig
 * Description:
 * date: 2020/6/10 18:05
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Configuration
@MapperScan("com.lt.sms.mapper") //dao层扫描
@ComponentScan("com.lt.config") //全局配置类扫描
@EnableDiscoveryClient  //开启注册中心
public class SmsConfig {

}
