package com.lt.order.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 * ClassName: OrderNoRandom
 * Description:
 * date: 2020/6/17 9:46
 *
 * @author 小狐
 * @since JDK 1.8
 */
public class OrderNoRandom {

    public static String createOrderNo (String courseId) {
        //获取当前时间
        StringBuffer buffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Random random = new Random();

        //课程id
        //当前时间秒数
        //随机的订单编号
        buffer.append(simpleDateFormat.format(new Date())).append("-")
                .append(courseId.substring(0,5)).append("-")
                .append(System.currentTimeMillis())
                .append(random.nextInt(1024));

        return buffer.toString();
    }

}
