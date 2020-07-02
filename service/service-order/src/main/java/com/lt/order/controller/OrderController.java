package com.lt.order.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.config.execptionhandler.LtExecption;
import com.lt.order.entity.Order;
import com.lt.order.entity.vo.OrderVo;
import com.lt.order.service.OrderService;
import com.lt.utils.ReturnResult;
import com.lt.utils.annotation.Unqiue;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-16
 */
//@CrossOrigin
@RestController
@RequestMapping("/order/orderInfo")
public class OrderController {

    @Autowired
    private OrderService orderService;
    /**
     * 创建订单信息
     * 实体类的的判断待项目完善会采用实体类的属性验证
     * @param orderVo
     * @return
     */
    @Unqiue
    @ApiOperation("创建订单信息")
    @PostMapping("/createOrder")
    public ReturnResult createOrder(@RequestBody OrderVo orderVo) {
         ReturnResult result= orderService.createOrder(orderVo);
         return result;
    }

    /**
     * 根据用户id与课程信息查询id
     *TODO 此方法可以更改
     * @return
     */
    @GetMapping("/getOrderStatus/{memberId}/{courseId}")
    public ReturnResult getOrderStatus(@PathVariable("memberId") String memberId,@PathVariable("courseId") String courseId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id",memberId);
        queryWrapper.eq("course_id",courseId);
        queryWrapper.eq("status",1);
        Order order = orderService.getOne(queryWrapper);
        if (order==null) {
            return ReturnResult.success("没有订单的信息",false);
        }
        return ReturnResult.success("有订单的信息",true);
    }
    /**
     * 获取订单信息
     * @param orderId
     * @return
     */
    @ApiOperation("获取订单id信息")
    @GetMapping("/getOrder/{orderId}")
    public ReturnResult getOrderInfo (@PathVariable("orderId") String orderId){
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
            orderQueryWrapper.eq("order_no",orderId);
            //根据订单号查询
            Order order = orderService.getOne(orderQueryWrapper);
            if (order==null) {
                return ReturnResult.failed("木得此订单信息");
            }

        return ReturnResult.success("订单信息查询成功",order);
    }

    /**
     * 根据用户id获取订单信息
     * @param memberId
     * @return
     */
    @ApiOperation("根据用户id获取订单信息")
    @GetMapping("/getMemberOrder/{memberId}")
    public ReturnResult getOrderMemberInfo (@PathVariable("memberId") String memberId){
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("member_id",memberId);
        //根据订单号查询
        Order order = orderService.getOne(orderQueryWrapper);
        if (order==null) {
            throw new LtExecption(20001,"暂时没有此订单的详细信息");
        }
        return ReturnResult.success("此订单已下单",order);
    }




}

