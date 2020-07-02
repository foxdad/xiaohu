package com.lt.utils.annotation;

import java.lang.annotation.*;

/**
 * ClassName: DiffMetiodTime
 * Description:
 * date: 2020/5/17 21:23
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DiffMetiodTime {
    //方法名
    String value();
}
