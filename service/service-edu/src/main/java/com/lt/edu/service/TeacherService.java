package com.lt.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lt.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.edu.entity.vo.TeacherVo;
import com.lt.utils.PageInfoVo;
import com.lt.utils.ReturnResult;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-16
 */
public interface TeacherService extends IService<Teacher> {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param teacherVo
     * @return
     */
    PageInfoVo getReturnResultList(long page , long pageSize, TeacherVo teacherVo);

    /**
     * 添加讲师
     * @param teacher
     * @return
     */
    ReturnResult insertTeacher(Teacher teacher);

    ReturnResult selectPage(Long page , Long pageSize);

    ReturnResult selectDetails(String teacherId);
}
