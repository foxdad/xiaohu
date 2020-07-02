package com.lt.edu.controller.front;

import com.lt.config.execptionhandler.LtExecption;
import com.lt.edu.client.OrderClient;
import com.lt.edu.entity.vo.course.Course;
import com.lt.edu.entity.vo.course.CourseQueryVo;
import com.lt.edu.service.CourseService;
import com.lt.edu.service.SubjectService;
import com.lt.utils.Constant;
import com.lt.utils.ReturnResult;
import com.lt.utils.cacheName.EhcacheUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * ClassName: CourseFrontController
 * Description:
 * date: 2020/6/12 22:25
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Api("课程信息分页查询")
@Validated
@RestController
@RequestMapping("/edu/frontCourse")
//@CrossOrigin
public class CourseFrontController {

   @Autowired
   private CourseService courseService;

   @Autowired
   private OrderClient orderClient;

//    @Cacheable(key = "#page+'-getpageCourse'+#pageSize",value = EhcacheUtils.MY_CACHE)
    @ApiOperation("展示页面查询所有讲师")
    @GetMapping("/getpageCourse/{teacherId}/{page}/{pageSize}")
    public ReturnResult getAllTeacherAndCourse(@PathVariable("teacherId")@NotNull(message = "bad request") String teacherId,
                                               @PathVariable("page")@Min(value = 1,message = "bad request") Long page ,
                                               @PathVariable("pageSize")@Min(value = 1,message = "bad request") Long pageSize) {
        if (page<0 || pageSize<0 || StringUtils.isEmpty(teacherId)) {
            throw new LtExecption(Constant.CODE_FAILED,"数据显示异常");
        }
        ReturnResult result = courseService.selectPage(page,pageSize,teacherId);
        return result;
    }
    @PostMapping("/getCourse/{page}/{pageSize}")
    public ReturnResult getAllCourse(@PathVariable("page")@Min(value = 1,message = "bad request") Long page,
                                     @PathVariable("pageSize")@Min(value = 1,message = "bad request") Long pageSize,
                                     @RequestBody(required = false)CourseQueryVo courseQueryVo) {
        if (page<0 || pageSize<0 ) {
            throw new LtExecption(Constant.CODE_FAILED,"数据显示异常");
        }
        return courseService.selectPageAllCourse(page,pageSize,courseQueryVo);
    }

    /**
     * 获取课程信息
     * @return
     */
    @GetMapping("/getCourseInfo/{id}")
    @ApiOperation("获取课程的详情")
    public ReturnResult getCourseInfo(@PathVariable("id")@NotNull(message = "bad request") String id) {
        if (StringUtils.isEmpty(id)) {
            throw new LtExecption(Constant.CODE_FAILED,"数据显示异常");
        }
        ReturnResult result = courseService.selectInfoWebById(id);
        return result;
    }

    /**
     * 获取订单的状态信息
     * @return
     */
    @GetMapping("/getCourseOrderInfo/{memberId}/{courseId}")
    public ReturnResult getCourseOrderInfo(@PathVariable("memberId")@NotNull(message = "bad request") String memberId, @PathVariable("courseId")@NotNull(message = "bad request") String courseId) {

         return orderClient.getOrderStatus(memberId, courseId);
    }
    /**
     * TODO 该方法还有改进的办法
     * 修改课程量
     * @param courseId
     * @param flag //判断是修改购买数量，浏览数量，课时数
     * @return
     */
   @PutMapping("/updateCourseInfo/{courseId}/{flag}")
   public ReturnResult updateCourseInfo(@PathVariable("courseId")@NotNull(message = "bad request") String courseId,@PathVariable("flag")@NotNull(message = "bad request") String flag) {
        //先查询在修改
        Course course = courseService.getById(courseId);
        if (course==null) {
            throw new LtExecption(20001,"课程信息丢失");
        }
        //标识判断增加那个
        if (Constant.COURSE_VIEWCOUNT.equals(flag)) {
            course.setViewCount(course.getViewCount()+1);
        }else if (Constant.COURSE_BYCOUNT.equals(flag)) {
            course.setBuyCount(course.getBuyCount()+1);
        }else{
            course.setLessonNum(course.getLessonNum()+1);
        }
        //修改
        boolean result = courseService.updateById(course);
        if (!result) {
            throw new LtExecption(20001,"服务器丢失");
        }
        return ReturnResult.success("记录成功",result);
   }
}
