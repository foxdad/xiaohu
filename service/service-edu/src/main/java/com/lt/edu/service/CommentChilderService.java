package com.lt.edu.service;

import com.lt.edu.entity.CommentChilder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.utils.ReturnResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-16
 */
public interface CommentChilderService extends IService<CommentChilder> {

    ReturnResult getPageList(Long page, Long pageSize, String courseId,String parentId);
}
