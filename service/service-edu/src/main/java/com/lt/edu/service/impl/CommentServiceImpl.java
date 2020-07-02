package com.lt.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lt.edu.entity.Comment;
import com.lt.edu.mapper.CommentMapper;
import com.lt.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.utils.PageInfoVo;
import com.lt.utils.ReturnResult;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-15
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public ReturnResult getPageList(Long page, Long pageSize, String courseId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        //根据课程id查询
        queryWrapper.eq("course_id",courseId);
        //按点赞数排序
        queryWrapper.orderByDesc("thumb_up_numberint");
        //数量一样按创建时间排序
        queryWrapper.orderByDesc("gmt_create");
        IPage<Comment> pageData = new Page<>(page,pageSize);

        IPage<Comment> commentIPage = baseMapper.selectPage(pageData, queryWrapper);
        if (commentIPage==null) {
            return ReturnResult.failed("数据查询失败");
        }
        return ReturnResult.success("数据查询成功", PageInfoVo.getPageInfoVo(commentIPage,pageSize));
    }
}
