package com.lt.config.aop;

import com.lt.utils.annotation.DiffMetiodTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * ClassName: AopAroundUtils
 * Description:
 * date: 2020/5/17 17:56
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Component
@Aspect
@Slf4j
public class AopAroundUtils {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Pointcut("execution(public * com.lt.*.controller..*.*(..))")
    public void point(){}
    @Pointcut("@annotation(com.lt.utils.annotation.DiffMetiodTime)")
    public void diffMethodTime(){}
    @Pointcut("@annotation(com.lt.utils.annotation.Unqiue)")
    public void unique(){}

//    @Around(value = "point()")
    @Around("diffMethodTime()")
    public Object Around (ProceedingJoinPoint joinPoint ) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        stopWatch.stop();
        //监控的请求时间
        long costTime = stopWatch.getLastTaskTimeMillis();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        //获取方法上面的注解
        Method method = methodSignature.getMethod();
        DiffMetiodTime annotation = method.getAnnotation(DiffMetiodTime.class);
        String value = " ";
        if (annotation !=  null) {
             value = annotation.value();
        }
        //获取当前执行方法名
        String methodName =  methodSignature.getDeclaringTypeName()+"-->"+methodSignature.getName();
        log.info("执行的路径"+methodName+"---->"+"该方法的功能是："+value+"-->"+"执行的时间"+costTime+"毫秒");
        System.out.println("执行的路径"+methodName+"---->"+"该方法的功能是："+value+"-->"+"执行的时间"+costTime+"毫秒");
        return result;
    }

//    @Before("unique()")
//    public Object unique(ProceedingJoinPoint joinPoint ) throws Throwable {
//
//        Object result = joinPoint.proceed(joinPoint.getArgs());
//        //监控的请求时间
//
//        //获取当前执行方法名
////        String methodName =  methodSignature.getDeclaringTypeName()+"-->"+methodSignature.getName();
////        log.info("执行的路径"+methodName+"---->"+"该方法的功能是："+value+"-->"+"执行的时间"+costTime+"毫秒");
////        System.out.println("执行的路径"+methodName+"---->"+"该方法的功能是："+value+"-->"+"执行的时间"+costTime+"毫秒");
//        return result;
//    }
}
