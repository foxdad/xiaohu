package com.lt.edu.mapper;

import com.lt.edu.entity.vo.course.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lt.utils.CommonEntity.CourseWebDTO;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
public interface CourseMapper extends BaseMapper<Course> {

    CourseWebDTO selectInfoWebById(String courseId);

}
