package com.lt.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.config.execptionhandler.LtExecption;
import com.lt.order.client.EduCourseClient;
import com.lt.order.entity.Order;
import com.lt.order.entity.vo.OrderVo;
import com.lt.order.mapper.OrderMapper;
import com.lt.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.order.utils.OrderNoUtil;
import com.lt.utils.CommonEntity.CourseWebDTO;
import com.lt.utils.ReturnResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-16
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    //远程调用
    @Autowired
    private EduCourseClient eduCourseClient;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 创建订单
     * @param orderVo
     * @return
     */
    @Override
    public ReturnResult createOrder(OrderVo orderVo) {

        Order order = new Order();
        //根据课程id获取课程信息
        ReturnResult courseInfoResult = eduCourseClient.getCourseInfo(orderVo.getCourseId());
        if (!courseInfoResult.getState()) {
           return ReturnResult.failed("所买课程通道关闭");
        }
        //防重
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",orderVo.getCourseId());
        queryWrapper.eq("member_id",orderVo.getMemberId());
        Order flagOrder = baseMapper.selectOne(queryWrapper);
        if (flagOrder!=null) {
            //防止reids挂了的时候的重复提交
            return ReturnResult.failed("此课程的订单已经创建成功了,请到我的订单去查询");
        }
        String json =  JSON.toJSONString(courseInfoResult.getData());
        CourseWebDTO courseWebDTO = JSON.parseObject(json,CourseWebDTO.class);
        //此处就不使用copy了有些值没有
        order.setCourseCover(courseWebDTO.getCover());
        order.setCourseTitle(courseWebDTO.getTitle());
        order.setTeacherName(courseWebDTO.getTeacherName());

        //再次copy属性
        BeanUtils.copyProperties(orderVo,order);
        //随机生成订单id
//        String rannomOrder = OrderNoRandom.createOrderNo(order.getCourseId());
        String rannomOrder = OrderNoUtil.getOrderNo();
        order.setOrderNo(rannomOrder);
        //添加
        int result = baseMapper.insert(order);
        //存储到redis中(2个小时过期)
        redisTemplate.opsForValue().set(order.getMemberId()+"-"+order.getCourseId(),rannomOrder,2, TimeUnit.HOURS);
        //把订单好返回
        return ReturnResult.success("下单成功",rannomOrder);
    }
}
