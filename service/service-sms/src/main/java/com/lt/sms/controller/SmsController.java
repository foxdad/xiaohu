package com.lt.sms.controller;

import com.lt.sms.config.RedisUtils;
import com.lt.sms.service.SmsService;
import com.lt.sms.utils.RandomUtils;
import com.lt.utils.ReturnResult;
import com.lt.utils.cacheName.EhcacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: SmsController
 * Description:
 * date: 2020/6/10 14:30
 * @author 小狐
 * @since JDK 1.8
 */
@RestController
@Validated
//@CrossOrigin
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     *
     * 接口还有问题
     *
     * @param phone
     * @return
     */
    @GetMapping("/send/{phone}")
    public ReturnResult send (@PathVariable("phone")@NotNull(message = "bad request") String phone) {
        Boolean flag = false;
//        if (StringUtils.isEmpty(phone)) {
//            return ReturnResult.failed("手机号错误");
//        }
        //判断是否能取到值
        Set<String> range1 = redisTemplate.opsForZSet().range(phone, 0, -1);
        //redis中有值时
        if (range1.size()!=0) {
            String range = range1.toArray()[0].toString();
            //获取标记值
            Double score = redisTemplate.opsForZSet().score(phone,range);
            double endScore = 5;//自动装配
            if (Math.abs(score-endScore)<=0) {
                return ReturnResult.failed("当天短信已到达上线");
            }
            //生成验证码
            Integer code = RandomUtils.getRandom();
            Map<String,Integer> map = new HashMap<>();
            map.put("code",code);
            flag = smsService.send(phone, map);
            if (flag) {
                ZSetOperations<String, String> stringZSetOperations = redisTemplate.opsForZSet();
                //清除改键的所有值
                redisTemplate.opsForZSet().removeRange(phone,0,-1);
                double resultScore = score +1;
                //重新设置值
                stringZSetOperations.add(phone, code.toString(),resultScore);
                //5分钟过期
                redisTemplate.expire(phone,5,TimeUnit.MINUTES);
                return ReturnResult.success("短信发送成功,请注意查收",flag);
            }
        }else {
            //第一次发送短信
            //生成验证码
            Integer code = RandomUtils.getRandom();
            Map<String, Integer> map = new HashMap<>();
            map.put("code", code);
            flag = smsService.send(phone, map);
            if (flag) {
                ZSetOperations<String, String> stringZSetOperations = redisTemplate.opsForZSet();

                Boolean result = stringZSetOperations.add(phone, code.toString(), 1);
                //5分钟过期
                redisTemplate.expire(phone,5,TimeUnit.MINUTES);
                return ReturnResult.success("短信发送成功,请注意查收", flag);
            }
        }
        return ReturnResult.failed("短信发送失败");
    }
//    @GetMapping("/send1/{phone}")
//    public void test (@PathVariable("phone") String phone) {
//        ZSetOperations<String, String> stringZSetOperations = redisTemplate.opsForZSet();
//        Boolean result = stringZSetOperations.add(phone, "123456", 1);
//        Boolean result2 = stringZSetOperations.add(phone, "000000", 1);
//        String range = redisTemplate.opsForZSet().range(phone, 0, -1).toArray()[0].toString();
//        Double score = redisTemplate.opsForZSet().score(phone,range);
//        redisTemplate.opsForZSet().removeRange(phone,0,-1);
//        System.out.println(range);
//    }
}
