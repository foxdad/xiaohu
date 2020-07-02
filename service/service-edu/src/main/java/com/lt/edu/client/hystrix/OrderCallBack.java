package com.lt.edu.client.hystrix;

import com.lt.config.execptionhandler.LtExecption;
import com.lt.edu.client.OrderClient;
import com.lt.utils.Constant;
import com.lt.utils.ReturnResult;

/**
 * ClassName: OrderCallBack
 * Description:
 * date: 2020/6/18 9:28
 *
 * @author 小狐
 * @since JDK 1.8
 */
public class OrderCallBack implements OrderClient {
    @Override
    public ReturnResult getOrderStatus(String memberId, String courseId) {
        return ReturnResult.failed("服务连接超时");
    }
}
