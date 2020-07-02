package com.lt.order.utils;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * ClassName: VxPayUtils
 * Description:
 * date: 2020/6/17 15:33
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Component
@ConfigurationProperties(prefix = "vx.pay")
@PropertySource(value = "VxPay.properties")
@Data
public class VxPayUtils implements InitializingBean {

    private String appId;

    private String partner;

    private String partnerKey;

    private String notifyUrl;

    public static String APPID;
    public static String PARTNER;
    public static String PARTNERKEY;
    public static String NOTIFYURL;
    //该方法在bean初始化的时候就执行
    @Override
    public void afterPropertiesSet() throws Exception {
        APPID = appId;
        PARTNER = partner;
        PARTNERKEY = partnerKey;
        NOTIFYURL = notifyUrl;
    }
}
