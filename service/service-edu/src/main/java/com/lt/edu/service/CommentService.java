package com.lt.edu.service;

import com.lt.edu.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.utils.ReturnResult;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-15
 */
public interface CommentService extends IService<Comment> {

    ReturnResult getPageList(Long page, Long pageSize, String courseId);
}
