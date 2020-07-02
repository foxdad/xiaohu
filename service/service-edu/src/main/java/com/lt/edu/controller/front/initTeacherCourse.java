package com.lt.edu.controller.front;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.edu.entity.vo.course.Course;
import com.lt.edu.entity.Teacher;
import com.lt.edu.service.CourseService;
import com.lt.edu.service.TeacherService;
import com.lt.utils.ReturnResult;
import com.lt.utils.cacheName.EhcacheUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: initTeacherCourse
 * Description:
 * date: 2020/6/9 11:47
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Api(description = "初始讲师，课程接口")
@RestController
@RequestMapping("/edu/init/ct")
//@CrossOrigin
public class initTeacherCourse {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;//注入redis

    /**
     * 查询前4位老师 EhcacheUtils.initTeacherCourse
     * @return
     */
    @Cacheable(key = "'alltc'",value = EhcacheUtils.MY_CACHE)
    @ApiOperation("查询热门的4个讲师")
    @GetMapping("/all/tc")
    public ReturnResult getInitTeacher() {
        List<Teacher> list = null;
        String flag = redisTemplate.opsForValue().get(EhcacheUtils.initTeacherCourse + "alltc");
        if (StringUtils.hasText(flag)) {
            return ReturnResult.success("数据显示成功",JSON.parseArray(flag,Teacher.class));
        }else {
            QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
            //根据排序降序查询
            teacherQueryWrapper.orderByDesc("sort");
            //查询4位
            teacherQueryWrapper.last("limit 4");
            list = teacherService.list(teacherQueryWrapper);
            if (CollectionUtils.isEmpty(list)) {
                return ReturnResult.failed("没想到吧,没有数据给你看");
            }
            redisTemplate.opsForValue().set(EhcacheUtils.initTeacherCourse + "alltc",JSON.toJSONString(list));
        }
        return ReturnResult.success("数据显示成功",list);
    }
    @Cacheable(key = "'allct'",value = EhcacheUtils.MY_CACHE)
    @ApiOperation("查询最新的8个课程")
    @GetMapping("/all/ct")
    public ReturnResult getInitCourse() {
        List<Course> list = null;
        String flag = redisTemplate.opsForValue().get(EhcacheUtils.initTeacherCourse + "allct");
        if (StringUtils.hasText(flag)) {
//            List<Course> courses = JSON.parseArray(flag, Course.class);
            return ReturnResult.success("数据显示成功",JSON.parseArray(flag,Course.class));
        }else{
            QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();

            courseQueryWrapper.orderByDesc("view_count");
            courseQueryWrapper.last("limit 8");
            list = courseService.list(courseQueryWrapper);
            if (CollectionUtils.isEmpty(list)) {
                return ReturnResult.failed("还是没有数据呀！");
            }
            //不设置过期时间了，因为首页数据不会经常发生变化
            redisTemplate.opsForValue().set(EhcacheUtils.initTeacherCourse + "allct",JSON.toJSONString(list));
        }
        return ReturnResult.success("数据显示成功",list);
    }
}
