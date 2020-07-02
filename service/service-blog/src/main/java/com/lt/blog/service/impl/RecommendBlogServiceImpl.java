package com.lt.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lt.blog.entity.Article;
import com.lt.blog.entity.Blogger;
import com.lt.blog.entity.GroupBlogger;
import com.lt.blog.entity.RecommendBlog;
import com.lt.blog.entity.vo.RecommendVo;
import com.lt.blog.mapper.RecommendBlogMapper;
import com.lt.blog.service.ArticleService;
import com.lt.blog.service.BloggerService;
import com.lt.blog.service.GroupBloggerService;
import com.lt.blog.service.RecommendBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.config.execptionhandler.LtExecption;
import com.lt.utils.Constant;
import com.lt.utils.PageInfoVo;
import com.lt.utils.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-28
 */
@Service
public class RecommendBlogServiceImpl extends ServiceImpl<RecommendBlogMapper, RecommendBlog> implements RecommendBlogService {

    @Autowired
    private GroupBloggerService groupBloggerService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private BloggerService bloggerService;

    @Override
    public ReturnResult getPageInfo(long page, long pageSize, RecommendVo recommendVo) {
        QueryWrapper<RecommendBlog> recommendBlogQueryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(recommendVo.getGroupId())) {
            recommendBlogQueryWrapper.eq("group_id",recommendVo.getGroupId());
        }
        if (recommendVo.getGmtCreate()!=null) {
            recommendBlogQueryWrapper.gt("gmt_create",recommendVo.getGmtCreate());
        }
        if(recommendVo.getStatus()!=null) {
            recommendBlogQueryWrapper.eq("status",recommendVo.getStatus());
        }
        IPage<RecommendBlog> recommendBlogPage  = new Page<>(page,pageSize);

        IPage<RecommendBlog> recommendBlogPageData = baseMapper.selectPage(recommendBlogPage, recommendBlogQueryWrapper);

        if (recommendBlogPageData==null) {
            return ReturnResult.failed("分页查询错误");
        }
        return ReturnResult.success("分页查询成功", PageInfoVo.getPageInfoVo(recommendBlogPageData,pageSize));
    }

    /**
     * 审核通过
     * TODO 幂等待实现
     * @param id
     * @param recommendGroupId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnResult saveOrUpdateArticle(String id,String recommendGroupId) {
        RecommendBlog recommendBlog = new RecommendBlog();
        recommendBlog.setStatus(1);
        recommendBlog.setId(id);
        //审核信息
        int flag = baseMapper.updateById(recommendBlog);
        if (flag!=1) {
            ReturnResult.failed("审核信息中断");
        }
        //查询指定分组
        GroupBlogger groupBlogger = groupBloggerService.getById(recommendGroupId);
        //查询审核信息
        RecommendBlog recommendBlogData = baseMapper.selectById(id);
        //添加文章
        Article article = new Article();
        article.setArticleTitle(recommendBlogData.getTitle());
        article.setArticleContext(recommendBlogData.getContent());
        article.setGroupId(groupBlogger.getId());
        article.setGroupName(groupBlogger.getGroupName());
        article.setArticleUrl(recommendBlogData.getUrl());
        //添加文章
        boolean save = articleService.save(article);
        if (!save) {
            throw new LtExecption(Constant.CODE_FAILED,"文章添加失败");
        }
        //添加博主
        //查询是否存在博主了
        QueryWrapper<Blogger> bloggerQueryWrapper = new QueryWrapper<>();
        bloggerQueryWrapper.eq("blogger_name",recommendBlogData.getName());

        Blogger blogger = bloggerService.getOne(bloggerQueryWrapper);
        //添加博主
        if (blogger==null) {
            blogger = new Blogger();
            blogger.setBloggerName(recommendBlogData.getName());
            blogger.setUrl(recommendBlogData.getLinked());
            boolean save1 = bloggerService.save(blogger);
            if (!save1) {
                throw new LtExecption(Constant.CODE_FAILED,"博主添加失败");
            }
        }

        //添加审核信息
        return ReturnResult.success("审核通过",true);
    }
}
