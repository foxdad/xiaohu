package com.lt.sms.service;

import java.util.Map;

/**
 * ClassName: SmsService
 * Description:
 * date: 2020/6/10 14:32
 *
 * @author 刘腾
 * @since JDK 1.8
 */
public interface SmsService {
    Boolean send(String phone, Map<String,Integer> code);
}
