package com.lt.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lt.blog.entity.Blogger;
import com.lt.blog.mapper.BloggerMapper;
import com.lt.blog.service.BloggerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.utils.PageInfoVo;
import com.lt.utils.ReturnResult;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-25
 */
@Service
public class BloggerServiceImpl extends ServiceImpl<BloggerMapper, Blogger> implements BloggerService {

    @Override
    public ReturnResult getPage(long page, long pageSize) {
        QueryWrapper<Blogger> bloggerQueryWrapper = new QueryWrapper<>();

        bloggerQueryWrapper.orderByDesc("view_count");


        IPage<Blogger> bloggerIPage = new Page<>(page,pageSize);

        IPage<Blogger> pageData = baseMapper.selectPage(bloggerIPage, bloggerQueryWrapper);

        if(pageData==null) {
            return ReturnResult.failed("显示失败");
        }

        return ReturnResult.success("有博主啦",PageInfoVo.getPageInfoVo(pageData,pageSize));
    }
}
