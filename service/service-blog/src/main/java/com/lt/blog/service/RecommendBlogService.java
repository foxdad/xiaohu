package com.lt.blog.service;

import com.lt.blog.entity.RecommendBlog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.blog.entity.vo.RecommendVo;
import com.lt.utils.ReturnResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-28
 */
public interface RecommendBlogService extends IService<RecommendBlog> {

    ReturnResult getPageInfo(long page, long pageSize, RecommendVo recommendVo);

    ReturnResult saveOrUpdateArticle(String id,String recommendGroupId);
}
