package com.lt.order.config.Listener;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.order.entity.Order;
import com.lt.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.nio.charset.StandardCharsets;

/**
 * ClassName: KeyExpiredListener
 * Description:
 * date: 2020/6/21 9:07
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Slf4j
public class KeyExpiredListener extends KeyExpirationEventMessageListener {

    @Autowired
    private OrderService orderService;

    public KeyExpiredListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel(),StandardCharsets.UTF_8);
        //过期的key
        String key = new String(message.getBody(), StandardCharsets.UTF_8);
       //删除订单表的订单
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id",key.split("-")[0]);
        wrapper.eq("course_id",key.split("-")[1]);
        boolean remove = orderService.remove(wrapper);
        if(remove){
            log.info("redis key 过期：pattern={},channel={},key={}",new String(pattern),channel,key);
        }else{
            log.error("redis key 过期，订单任务执行失败：pattern={},channel={},key={}",new String(pattern),channel,key);
        }

    }
}
