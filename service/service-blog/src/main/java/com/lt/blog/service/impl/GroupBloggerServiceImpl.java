package com.lt.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.blog.entity.Article;
import com.lt.blog.entity.GroupBlogger;
import com.lt.blog.entity.dto.GroupDto;
import com.lt.blog.mapper.ArticleMapper;
import com.lt.blog.mapper.GroupBloggerMapper;
import com.lt.blog.service.ArticleService;
import com.lt.blog.service.GroupBloggerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.utils.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-28
 */
@Service
public class GroupBloggerServiceImpl extends ServiceImpl<GroupBloggerMapper, GroupBlogger> implements GroupBloggerService {

    @Resource
    private ArticleMapper articleMapperr;

    @Override
    public ReturnResult selectAll() {

        List<GroupBlogger> groupBloggers = baseMapper.selectList(null);
        if (CollectionUtils.isEmpty(groupBloggers)) {
            return ReturnResult.failed("暂时没有文章分类");
        }
        return ReturnResult.success("查询文章分类成功",groupBloggers);
    }

    @Override
    public ReturnResult getGroupCount() {
        //查询所有的分组
        List<GroupBlogger> groupBloggers = baseMapper.selectList(null);
        List<GroupDto> groupDtoList = new ArrayList<>();

        for (GroupBlogger item :groupBloggers) {
            QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("group_id",item.getId());
            Integer count = articleMapperr.selectCount(queryWrapper);
            if (count==0) {
                continue;
            }
            GroupDto groupDto = new GroupDto();
            groupDto.setCount(count);
            groupDto.setGroupName(item.getGroupName());
            groupDtoList.add(groupDto);
            groupDto = null;
        }
        return ReturnResult.success("数据统计成功",groupDtoList);
    }
}
