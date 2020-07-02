package com.lt.blog.controller;


import com.lt.blog.entity.RecommendBlog;
import com.lt.blog.entity.vo.RecommendForntVo;
import com.lt.blog.entity.vo.RecommendVo;
import com.lt.blog.service.RecommendBlogService;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-28
 */
@Api("推荐文章添加")
@Validated
@RestController
@RequestMapping("/blog/recommend")
public class RecommendBlogController {

    @Autowired
    private RecommendBlogService recommendBlogService;

    @ApiOperation("推荐文章添加")
    @PostMapping("/save/recommend")
    public ReturnResult saveRecommendBlog(@RequestBody RecommendForntVo recommendBlog){
        RecommendBlog recommendBlogData = new RecommendBlog();
        BeanUtils.copyProperties(recommendBlog,recommendBlogData);
        boolean save = recommendBlogService.save(recommendBlogData);
        if (!save) {
            return ReturnResult.failed("推荐失败");
        }
        return ReturnResult.success("推荐成功",save);
    }

    /**
     * 文章查询分页
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation("文章查询分页")
    @PostMapping("/getPageInfo/{page}/{pageSize}")
    public ReturnResult getPageInfo(@PathVariable("page")@Min(value = 1,message = "bad request") long page, @PathVariable("pageSize")@Min(value = 1,message = "bad request") long pageSize,
                                    @RequestBody RecommendVo recommendVo) {

        ReturnResult result = recommendBlogService.getPageInfo(page,pageSize,recommendVo);

        return result;
    }

    @DeleteMapping("/removeRecommend/{id}")
    public ReturnResult removeRecommend(@PathVariable("id")@NotNull(message = "删除id不能是空") String id) {

        boolean flag = recommendBlogService.removeById(id);

        if (!flag) {
            return ReturnResult.failed("删除失败");
        }
        return ReturnResult.success("删除成功",flag);
    }

    /**
     * 根据id修改审核状态
     * @param id
     * @return
     */
    @GetMapping("/updataRecommend/{id}/{recommendGroupId}")
    public ReturnResult updataRecommend(@PathVariable("id")String id,@PathVariable("recommendGroupId") String recommendGroupId){

        ReturnResult result = recommendBlogService.saveOrUpdateArticle(id,recommendGroupId);

        return result;
    }



}

