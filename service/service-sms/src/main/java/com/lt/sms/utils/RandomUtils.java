package com.lt.sms.utils;

import java.util.Random;

/**
 * ClassName: RandomUtils
 * Description:
 * date: 2020/6/10 14:42
 *
 * @author 刘腾
 * @since JDK 1.8
 */
public class RandomUtils {
    public static int getRandom() {
        Random random = new Random();
        int num = 1000;
        int res = random.nextInt(8999) + num;
        return res;
    }
}
