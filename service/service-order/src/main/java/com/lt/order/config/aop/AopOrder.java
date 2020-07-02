package com.lt.order.config.aop;

import com.lt.order.entity.vo.OrderVo;
import com.lt.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * ClassName: AopOrder
 * Description:
 * date: 2020/6/17 18:13
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Component
@Aspect
@Slf4j
public class AopOrder {
    @Autowired
    private  RedisTemplate<String,String> redisTemplate;

    @Pointcut("execution(public * com.lt.*.controller..*.*(..))")
    public void point(){}

    @Pointcut("@annotation(com.lt.utils.annotation.Unqiue)")
    public void unique(){}

    @Around("unique()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        //参数强转
        OrderVo orderVo = (OrderVo)args[0];
        String only = redisTemplate.opsForValue().get(orderVo.getMemberId()+ "-" +orderVo.getCourseId());
        //为空就执行目标方法
        if (StringUtils.isEmpty(only)){
            return joinPoint.proceed();
        }else {
            //可以把状态改成false(订单就不重复提示)
            //把已经有的订单发送给用户
            return ReturnResult.success("防止重复添加",only);
        }

    }
}
