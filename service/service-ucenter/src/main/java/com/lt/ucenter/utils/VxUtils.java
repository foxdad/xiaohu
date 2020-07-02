package com.lt.ucenter.utils;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * ClassName: VXUtils
 * Description:
 * date: 2020/6/12 11:56
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Component
@ConfigurationProperties(prefix = "wx.open")
@PropertySource(value = "vx.properties")
@Data
public class VxUtils implements InitializingBean {
    private  String appId;

    private  String appSecret;
    private  String redirectUrl;

    public static String APP_ID;
    public static String APP_SECRET;
    public static String REDIRECT_URL;
    //该方法在bean初始化的时候就执行
    @Override
    public void afterPropertiesSet() throws Exception {
        APP_ID = appId;
        APP_SECRET = appSecret;
        REDIRECT_URL = redirectUrl;
    }
}
