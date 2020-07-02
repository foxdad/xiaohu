package com.lt.order.service;

import com.lt.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.order.entity.vo.OrderVo;
import com.lt.utils.ReturnResult;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-16
 */
public interface OrderService extends IService<Order> {

    ReturnResult createOrder(OrderVo orderVo);
}
