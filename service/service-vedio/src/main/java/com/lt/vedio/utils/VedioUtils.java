package com.lt.vedio.utils;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * ClassName: VedioUtils
 * Description:
 * date: 2020/6/20 12:53
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Component
@ConfigurationProperties(prefix = "aliyun.vod.file")
@PropertySource(value = "vedio.properties")
@Data
public class VedioUtils implements InitializingBean {

    //    @Value("${keyid}")
    private String keyId;
    //    @Value("${keysecret}")
    private String keySecret;


    public static String KEY_ID;
    public static String KEY_SECRET;

    //该方法在bean初始化的时候就执行
    @Override
    public void afterPropertiesSet() throws Exception {
        KEY_ID = keyId;
        KEY_SECRET = keySecret;
    }
}
