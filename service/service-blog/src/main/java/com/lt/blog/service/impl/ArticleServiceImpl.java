package com.lt.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lt.blog.entity.Article;
import com.lt.blog.mapper.ArticleMapper;
import com.lt.blog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.utils.PageInfoVo;
import com.lt.utils.ReturnResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-25
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ReturnResult getPageInfo(long page, long pageSize,String groupName) {

        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        if (!"null".equals(groupName)) {
            System.out.println("经理了");
            queryWrapper.eq("group_name",groupName);
        }
        queryWrapper.orderByDesc("gmt_create");

        IPage<Article> iPage = new Page<>(page,pageSize);

        IPage<Article> pageData = baseMapper.selectPage(iPage, queryWrapper);
        if (pageData==null) {
            return ReturnResult.failed("还没添加博主，请等待小编收集博主的精选博客添加");
        }
        PageInfoVo pageInfoVo = PageInfoVo.getPageInfoVo(pageData, pageSize);

        return ReturnResult.success("查询成功",pageInfoVo);
    }

}
