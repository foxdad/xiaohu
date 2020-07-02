package com.lt.vedio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: VedioApplication
 * Description:
 * date: 2020/6/7 17:55
 *
 * @author 刘腾
 * @since JDK 1.8
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class VedioApplication {
    public static void main(String[] args) {
        SpringApplication.run(VedioApplication.class,args);
    }
}
