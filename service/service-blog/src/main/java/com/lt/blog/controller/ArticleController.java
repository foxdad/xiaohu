package com.lt.blog.controller;


import com.lt.blog.service.ArticleService;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-25
 */
@Api("博客文章")
@Validated
@RestController
@RequestMapping("/blog/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 博客文章分页查询
     * TODO参数验证
     * @param page
     * @param pageSize
     * @return
     */

    @ApiOperation("博客文章分页查询")
    @GetMapping("/getArticlePage/{page}/{pageSize}/{groupName}")
    public ReturnResult getArticlePage(@PathVariable("page") @Min(value = 1,message = "bad request") long page,@Min(value = 1,message = "bad request") @PathVariable("pageSize") long pageSize,
                                       @PathVariable(required = false,value = "groupName") String groupName) {
        ReturnResult result= articleService.getPageInfo(page,pageSize,groupName);
        return result;
    }
    /**
     * 删除文章
     * @param id
     * @return
     */
    @ApiOperation("根据id删除文章")
    @DeleteMapping("/removeArticle")
    public ReturnResult removeArticle(@PathVariable("id") @NotNull(message = "请指定删除id") String id) {

        boolean flag = articleService.removeById(id);

        if (!flag) {
            return ReturnResult.failed("删除该文章失败");
        }
        return ReturnResult.success("删除成功",flag);
    }

}

