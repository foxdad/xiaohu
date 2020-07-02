package com.lt.order.controller;


import com.lt.config.execptionhandler.LtExecption;
import com.lt.order.service.PayLogService;
import com.lt.utils.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-16
 */
@RestController
@Validated
@RequestMapping("/order/paylog")
//@CrossOrigin
public class PayLogController {

    @Autowired
    private PayLogService payService;
    /**
     * 生成二维码
     *
     * @return
     */
    @GetMapping("/createNative/{orderNo}")
    public ReturnResult createNative(@PathVariable @NotNull(message = "bad request") String orderNo) {
        Map map = payService.createNative(orderNo);
        return ReturnResult.success("成功",map);
    }

    /**
     * 修改状态信息
     * @param orderNo
     * @return
     */
    @GetMapping("/queryPayStatus/{orderNo}")
    public ReturnResult queryPayStatus(@PathVariable("orderNo") @NotNull(message = "bad request") String orderNo) {
        //调用查询接口
        Map<String, String> map = payService.queryPayStatus(orderNo);
        if (map == null) {//出错
            throw new LtExecption(20001,"支付出错");
        }
        if (map.get("trade_state").equals("SUCCESS")) {//如果成功
            //更改订单状态
            payService.updateOrderStatus(map);
            return ReturnResult.success("支付成功","支付成功");
        }

        return ReturnResult.failedPay("支付中");
    }

}

