package com.lt.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * ClassName: RedisUtils
 * Description:
 * date: 2020/6/11 14:02
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Component
public class RedisUtils {
    @Autowired
    private static RedisTemplate<String,String> redisTemplate;

    /**
     * zset添加
     * @param key
     * @param value
     * @param count
     * @return
     */
     public static Boolean zSetAdd(String key ,String value ,double count){
         ZSetOperations<String, String> stringZSetOperations = redisTemplate.opsForZSet();
         Boolean result = stringZSetOperations.add(key, value, count);
         return result;
     }
    public static Set<String> zSetGet(String key){
//        ZSetOperations<String, String> stringZSetOperations = redisTemplate.opsForZSet();
//        Boolean result = stringZSetOperations.
        Set<String> range = redisTemplate.opsForZSet().range(key, 0, -1);
        return range;
    }
}
