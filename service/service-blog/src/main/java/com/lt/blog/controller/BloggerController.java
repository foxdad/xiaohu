package com.lt.blog.controller;


import com.lt.blog.service.BloggerService;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-25
 */
@Api(produces = "博主")
@Validated
@RestController
@RequestMapping("/blog/blogger")
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

    /**
     * 根据排序查询博主
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/getBlogger/{page}/{pageSize}")
    public ReturnResult getBlogger(@PathVariable("page")@Min(value = 1 ,message = "bad request") long page, @PathVariable("pageSize")@Min(value = 1 ,message = "bad request")  long pageSize){

        ReturnResult result = bloggerService.getPage(page,pageSize);
        return result;
    }

}

