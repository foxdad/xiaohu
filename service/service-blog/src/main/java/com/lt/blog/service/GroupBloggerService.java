package com.lt.blog.service;

import com.lt.blog.entity.GroupBlogger;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.utils.ReturnResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-28
 */
public interface GroupBloggerService extends IService<GroupBlogger> {

    ReturnResult selectAll();

    ReturnResult getGroupCount();
}
