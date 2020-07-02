package com.lt.edu.controller.front;

import com.lt.edu.service.TeacherService;
import com.lt.utils.ReturnResult;
import com.lt.utils.cacheName.EhcacheUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * ClassName: CourseFrontContrller
 * Description:
 * date: 2020/6/12 15:52
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Api("前端讲师分页查询")
@Validated
@RestController
@RequestMapping("/edu/frontTeacher")
//@CrossOrigin
public class TeacherFrontContrller {

    @Autowired
    private TeacherService teacherService;
    /**
     * 前端讲师分页
     * @param page
     * @param pageSize
     * @return
     */
    @Cacheable(key = "#page+'-'+#pageSize",value = EhcacheUtils.MY_CACHE)
    @ApiOperation("展示页面查询所有讲师")
    @GetMapping("/getpageTeacher/{page}/{pageSize}")
    public ReturnResult getAllTeacher(@PathVariable("page")@Min(value = 1,message = "bad request") Long page ,
                                      @PathVariable("pageSize")@Min(value = 1,message = "bad request")Long pageSize) {
        if (page<0 || pageSize<0) {
            return ReturnResult.failed("数据错误");
        }
        ReturnResult result = teacherService.selectPage(page,pageSize);
        return result;
    }
    @Cacheable(key = "#teacherId",value = EhcacheUtils.MY_CACHE)
    @ApiOperation("展示页面查询讲师详情")
    @GetMapping("/getSelectDetails/{teacherId}")
    public ReturnResult getSelectDetails(@PathVariable("teacherId")@NotNull(message = "bad request") String teacherId){
        if (StringUtils.isEmpty(teacherId)) {
            return ReturnResult.failed("页面找不到了呀！");
        }
        return teacherService.selectDetails(teacherId);
    }
}
