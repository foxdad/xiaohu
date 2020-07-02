package com.lt.edu.controller;


import com.lt.edu.entity.vo.course.Course;
import com.lt.edu.service.CourseService;
import com.lt.edu.service.impl.CourseServiceImpl;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
@Api(produces = "课程操作")
@Validated
@RestController
@RequestMapping("/edu/course")
//@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;
    /**
     * TODO 待修改
     * @param course
     * @return
     */
    @PostMapping("/insert/course")
    public ReturnResult insertCourse(@RequestBody Course course) {
        boolean save = courseService.save(course);
        String id = course.getId();
        if (!save) {
            return  ReturnResult.failed("添加失败");
        }
        return ReturnResult.success("课程添加成功",id);
    }
    @GetMapping("/admin/getcourse/{courseId}")
    public ReturnResult getCourse (@PathVariable @NotNull(message = "bad request") String courseId){

        Course course = courseService.getById(courseId);
        if (course==null) {
            return ReturnResult.failed("没有此课程的信息");
        }
        return ReturnResult.success("课程回显成功",course);

    }


}

