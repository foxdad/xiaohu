package com.lt.blog.service;

import com.lt.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.utils.ReturnResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-25
 */
public interface ArticleService extends IService<Article> {

    ReturnResult getPageInfo(long page, long pageSize,String groupName);

}
