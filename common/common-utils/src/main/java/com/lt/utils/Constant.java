package com.lt.utils;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * ClassName: Constant
 * Description:
 * date: 2020/5/16 20:50
 *存储常量的对象
 * @author 刘腾
 * @since JDK 1.8
 */
public class Constant {
    //防止外部私有化
    private Constant(){}
    //成功状态码
    public static final Integer CODE_SUCCESS = 20000;
    //失败状态码
    public static final Integer CODE_FAILED = 20001;

    //支付中状态码
    public static final Integer CODE_FAILEDPAY = 25000;

    //降级回调
    public static final Integer CODE_HYSTIRX = 30000;

    //课程的常量定义
    public static final String COURSE_DRAFT = "Draft";

    public static final String COURSE_NORMAL = "Normal";
    //
    public static final String COURSE_BYCOUNT = "buyCount";

    public static final String COURSE_VIEWCOUNT = "viewCount";
}

