package com.lt.order.client;

import com.lt.order.client.hystrix.CallBackCourseClient;
import com.lt.utils.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * ClassName: EduCourse
 * Description:
 * date: 2020/6/16 17:47
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Component
@FeignClient(value = "service-edu",fallback = CallBackCourseClient.class)
public interface EduCourseClient {
    /**
     * 根据课程id获取课程信息
     * @param id
     * @return
     */
    @GetMapping("/edu/frontCourse/getCourseInfo/{id}")
    public ReturnResult getCourseInfo(@PathVariable("id") String id);

    /**
     * 课程购买量修改
     * @param courseId
     * @param flag
     * @return
     */
    @PutMapping("/edu/frontCourse/updateCourseInfo/{courseId}/{flag}")
    public ReturnResult updateCourseInfo(@PathVariable("courseId") String courseId,@PathVariable("flag") String flag);

}
