package com.lt.edu.client;

import com.lt.edu.client.hystrix.OrderCallBack;
import com.lt.utils.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: OrderClient
 * Description:
 * date: 2020/6/18 9:00
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Component
@FeignClient(value = "service-order",fallback = OrderCallBack.class)
public interface OrderClient {

    @GetMapping("/order/orderInfo/getOrderStatus/{memberId}/{courseId}")
    public ReturnResult getOrderStatus(@PathVariable("memberId") String memberId, @PathVariable("courseId") String courseId);
}
