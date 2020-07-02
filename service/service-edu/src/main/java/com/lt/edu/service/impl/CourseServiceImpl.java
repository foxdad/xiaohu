package com.lt.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lt.edu.entity.vo.course.Course;
import com.lt.utils.CommonEntity.CourseWebDTO;
import com.lt.edu.entity.vo.course.CourseQueryVo;
import com.lt.edu.mapper.CourseMapper;
import com.lt.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.utils.PageInfoVo;
import com.lt.utils.ReturnResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {


    @Override
    public ReturnResult selectPage(Long page, Long pageSize,String teacherId) {
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("teacher_id",teacherId);
        IPage<Course> iPage = new Page<>(page,pageSize);
        IPage<Course> pageData = baseMapper.selectPage(iPage, courseQueryWrapper);
        if (pageData==null ||pageData.getSize()==0) {
            return ReturnResult.failed("课程数据查询失败");
        }
        return ReturnResult.success("数据查询成功",PageInfoVo.getPageInfoVo(pageData, pageSize));
    }

    @Override
    public ReturnResult selectPageAllCourse(Long page, Long pageSize, CourseQueryVo courseQueryVo) {

        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(courseQueryVo.getSubjectParentId())) {
            queryWrapper.eq("subject_parent_id",courseQueryVo.getSubjectParentId());
        }
        if (!StringUtils.isEmpty(courseQueryVo.getSubjectId())) {
            queryWrapper.eq("subject_id",courseQueryVo.getSubjectId());
        }
        //销量排序
        if (!StringUtils.isEmpty(courseQueryVo.getBuyCountSort())) {
            queryWrapper.orderByDesc("buy_count");
        }
        //创建时间排序
        if (!StringUtils.isEmpty(courseQueryVo.getGmtCreateSort())) {
            queryWrapper.orderByDesc("gmt_create");
        }
        //价格排序
        if (!StringUtils.isEmpty(courseQueryVo.getPriceSort())) {
            queryWrapper.orderByDesc("price");
        }
        //课程分类
        IPage<Course> courseIpage = new Page(page,pageSize);
        //course分页查询
        IPage<Course> pageData = baseMapper.selectPage(courseIpage, queryWrapper);
        if (pageData==null) {
            return ReturnResult.failed("数据查询失败");
        }
        return ReturnResult.success("数据查询成功",PageInfoVo.getPageInfoVo(pageData,pageSize));
    }
    /**
     * 获取课程信息
     * @param id
     * @return
     */
    @Override
    public ReturnResult selectInfoWebById(String id) {
        CourseWebDTO courseWebDTO = baseMapper.selectInfoWebById(id);
        if (courseWebDTO ==null) {
            return ReturnResult.failed("数据查询失败");
        }
        return ReturnResult.success("数据查询成功", courseWebDTO);
    }
}
