package com.lt.edu.service;

import com.lt.edu.entity.vo.course.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.edu.entity.vo.course.CourseQueryVo;
import com.lt.utils.ReturnResult;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
public interface CourseService extends IService<Course> {

    ReturnResult selectPage(Long page, Long pageSize,String teacherId);

    ReturnResult selectPageAllCourse(Long page, Long pageSize, CourseQueryVo courseQueryVo);
    /**
     * 获取课程信息
     * @param id
     * @return
     */
    ReturnResult selectInfoWebById(String id);
}
