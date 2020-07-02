package com.lt.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: GatWayApplication
 * Description:
 * date: 2020/6/19 15:45
 *
 * @author 小狐
 * @since JDK 1.8
 */
@EnableDiscoveryClient //注册到
@SpringBootApplication
public class GatWayApplication {
    public static void main(String[] args) {

        SpringApplication.run(GatWayApplication.class,args);
    }
}
