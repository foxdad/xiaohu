package com.lt.vedio.client.hyxtris;

import com.lt.utils.ReturnResult;
import com.lt.vedio.client.OrderClient;

/**
 * ClassName: OrderCallBack
 * Description:
 * date: 2020/6/24 10:09
 *
 * @author 小狐
 * @since JDK 1.8
 */
public class OrderCallBack implements OrderClient {
    @Override
    public ReturnResult getOrderStatus(String memberId, String courseId) {
        return ReturnResult.failedBack("服务连接超时");
    }
}
