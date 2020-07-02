package com.lt.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lt.edu.entity.Teacher;
import com.lt.edu.entity.vo.TeacherVo;
import com.lt.edu.mapper.TeacherMapper;
import com.lt.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.utils.PageInfoVo;
import com.lt.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-16
 */
@Slf4j
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;



    @Override
    public PageInfoVo getReturnResultList(long page , long pageSize, TeacherVo teacherVo){
        //属性copy
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherVo,teacher);
        //条件判断
        QueryWrapper<Teacher> teacherVoQueryWrapper = new QueryWrapper<>();
        if (teacher.getGmtCreate()!=null && teacher.getGmtModified()!=null) {
            teacherVoQueryWrapper.between("gmt_create",teacher.getGmtCreate(),teacher.getGmtModified());
        }
        if (!StringUtils.isEmpty(teacher.getName())) {
            teacherVoQueryWrapper.likeRight("name",teacher.getName());
        }
        if (teacher.getLevel()!=null) {
            teacherVoQueryWrapper.eq("level",teacher.getLevel());
        }
        //降序排列
        teacherVoQueryWrapper.orderByDesc("gmt_create");
        IPage<Teacher> teacherIPage = new Page<>(page,pageSize);
        log.info("讲师分页查询");
        IPage<Teacher> pageTeacher = teacherMapper.selectPage(teacherIPage, teacherVoQueryWrapper);
        PageInfoVo pageInfoVo = PageInfoVo.getPageInfoVo(pageTeacher, pageSize);
        if (pageTeacher != null) {
            return pageInfoVo;
        }else{
            return null;
        }
    }
    /**
     * 添加讲师
     * @param teacher
     * @return
     */
    @Override
    public ReturnResult insertTeacher(Teacher teacher) {
        int insert = teacherMapper.insert(teacher);
        if (insert==1) {
            log.info("添加teacher成功"+teacher);
           return ReturnResult.success("添加成功",insert);
        }else{
          return   ReturnResult.failed("添加失败");
        }
    }
    /**
     * 展示页面的分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public ReturnResult selectPage(Long page , Long pageSize) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        //排名降序
        teacherQueryWrapper.orderByDesc("sort");
        IPage<Teacher> teacherPage = new Page<>(page,pageSize);

        IPage<Teacher> teacherIPage = baseMapper.selectPage(teacherPage, teacherQueryWrapper);
        if (teacherIPage!=null) {
          return ReturnResult.success("讲师列表查询成功",PageInfoVo.getPageInfoVo(teacherIPage,pageSize));
        }
        return ReturnResult.failed("讲师列表查询失败");
    }

    /**
     * 根据讲师id查询所属数据
     * @return
     */
    @Override
    public ReturnResult selectDetails(String teacherId) {
        //查询详情
        Teacher teacher = baseMapper.selectById(teacherId);
        if (teacher==null) {
            return ReturnResult.failed("数据查询失败");
        }
//        QueryWrapper<Course> queryWrapper =  new QueryWrapper<>();
//        queryWrapper.eq("teacher_id",teacherId);
//        //查询指定课程
//        List<Course> courseList = courseService.list(queryWrapper);
//        Map<String,Object> map = new HashMap<>();
//        map.put("teacher",teacher);
//        map.put("courseList",courseList);

        return ReturnResult.success("数据查询成功",teacher);
    }

}
