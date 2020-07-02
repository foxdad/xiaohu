package com.lt.order.client.hystrix;

import com.lt.config.execptionhandler.LtExecption;
import com.lt.order.client.EduCourseClient;
import com.lt.utils.ReturnResult;
import org.springframework.stereotype.Service;

/**
 * ClassName: CallBackCourse
 * Description:
 * date: 2020/6/16 17:52
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Service
public class CallBackCourseClient implements EduCourseClient {
    @Override
    public ReturnResult getCourseInfo(String id) {
        return ReturnResult.failed("服务连接超时");
    }

    @Override
    public ReturnResult updateCourseInfo(String courseId, String flag) {
        return ReturnResult.failed("支付异常,请稍后支付");
    }
}
