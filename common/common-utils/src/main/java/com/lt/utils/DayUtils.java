package com.lt.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName: DayUtils
 * Description:
 * date: 2020/6/18 17:59
 *
 * @author 小狐
 * @since JDK 1.8
 */
public class DayUtils {
    /**
     * 获取昨天日期
     * @return
     */
    public static String getYesterDay(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        return sp.format(d);
    }

    /**
     * 获取当天日期
     * @return
     */
    public static String getNowDay () {
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,0);
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        return sp.format(cal.getTime());
    }

    /**
     * 获取当天日期包括时分秒
     * @return
     */
    public static String getNowDayHMS() {

        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sp.format(new Date());
    }
}
