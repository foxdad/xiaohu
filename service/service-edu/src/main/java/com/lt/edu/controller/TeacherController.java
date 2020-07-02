package com.lt.edu.controller;


import com.lt.utils.annotation.DiffMetiodTime;
import com.lt.edu.entity.Teacher;
import com.lt.edu.entity.vo.TeacherVo;
import com.lt.edu.service.TeacherService;
import com.lt.utils.PageInfoVo;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-16
 */
@Api(description = "讲师类接口")
@Validated
@RestController
@RequestMapping("/edu/teacher")
//@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有的讲师
     * @return
     */
    @DiffMetiodTime("查询所有讲师")
    @ApiOperation("查询所有讲师")
    @GetMapping("/getTeacher")
    public ReturnResult findAll() {
        List<Teacher> teacherList = teacherService.list(null);
        if (teacherList==null) {
            return  ReturnResult.failed("数据查询失败");
        }
        return  ReturnResult.success("数据查询成功",teacherList);
    }
    @DiffMetiodTime("分页查询讲师")
    @ApiOperation("分页查询讲师")
    @PostMapping("/listTeacher/{page}/{pageList}")
    public ReturnResult getReturnResultList(@PathVariable("page")@Min(value = 1,message = "bad request") long page ,
                                            @PathVariable("pageList")@Min(value = 1,message = "bad request") long pageSize,
                                            @RequestBody TeacherVo teacherVo) {
        PageInfoVo returnResultList = teacherService.getReturnResultList(page, pageSize,teacherVo);
        if (returnResultList!=null) {
            return ReturnResult.success("数据查询成功",returnResultList);
        }else{
            return ReturnResult.failed("分页查询失败");
        }
    }
    @DiffMetiodTime("根据id查询用户")
    @ApiOperation("根据id查询用户")
    @GetMapping("/getByTeacher/{id}")
    public ReturnResult getByTeacher(@PathVariable("id") @NotNull(message = "bad request")  String id) {
        Teacher byTeacher = teacherService.getById(id);
        if (byTeacher==null) {
            return ReturnResult.failed("系统繁忙,请稍后重试");
        }
        return ReturnResult.success("查询成功",byTeacher);
    }
    @DiffMetiodTime("修改用户信息")
    @ApiOperation("修改用户信息")
    @PostMapping("/updateTeacher")
    public ReturnResult updateTeacher (@RequestBody Teacher teacher) {
        boolean flag = teacherService.updateById(teacher);
        if (!flag) {
            return ReturnResult.failed("修改失败,请稍后重试");
        }
        return ReturnResult.success("修改成功",flag);
    }
    @DiffMetiodTime("添加讲师")
    @ApiOperation("添加讲师")
    @PostMapping("/insertTeacher")
    public ReturnResult insertTeacher(@Validated @RequestBody Teacher teacher) {
        ReturnResult returnResult = teacherService.insertTeacher(teacher);
        return returnResult;
    }
    @DiffMetiodTime("删除指定讲师")
    @ApiOperation("删除指定讲师")
    @DeleteMapping("/delete/{id}")
    public ReturnResult deleteTeacher(@ApiParam("讲师id") @PathVariable("id") @NotNull(message = "bad request")  String id ){
        boolean result = teacherService.removeById(id);
        if (result==false) {
            return ReturnResult.failed("删除失败");
        }
        return ReturnResult.success("删除成功",result);
    }
}

