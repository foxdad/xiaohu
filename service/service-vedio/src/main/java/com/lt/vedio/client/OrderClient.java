package com.lt.vedio.client;

import com.lt.utils.ReturnResult;
import com.lt.vedio.client.hyxtris.OrderCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: OrderClient
 * Description:
 * date: 2020/6/24 10:08
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
