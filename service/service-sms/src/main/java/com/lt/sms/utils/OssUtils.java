package com.lt.sms.utils;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * ClassName: OssUtils
 * Description:
 * date: 2020/5/24 12:40
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss.file")
@PropertySource(value = "oss.properties")
@Data
public class OssUtils implements InitializingBean {
//    @Value("${endpoint}")
    private String endpoint;
//    @Value("${keyid}")
    private String keyId;
//    @Value("${keysecret}")
    private String keySecret;
//    @Value("${bucketname}")
    private String bucketName;

    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;
    //该方法在bean初始化的时候就执行
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        KEY_ID = keyId;
        KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
    }
}
