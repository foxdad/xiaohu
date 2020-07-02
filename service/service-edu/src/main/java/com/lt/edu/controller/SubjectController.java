package com.lt.edu.controller;


import com.lt.edu.entity.vo.subject.OneSubject;
import com.lt.edu.entity.vo.subject.TwoSubject;
import com.lt.edu.service.SubjectService;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-25
 */
@Api("课程添加")
@RestController
@RequestMapping("/edu/subject")
//@CrossOrigin
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @ApiOperation("Excle添加数据")
    @PostMapping("/import")
    public ReturnResult addSubject (@RequestPart("file")MultipartFile multipartFile) {
        subjectService.addSubject(multipartFile,subjectService);
        return ReturnResult.success("课程添加成功","成功");
    }
    @ApiOperation("Subject多级查询")
    @GetMapping("/getAllSubject")
    public ReturnResult getAllSubject() {
        List<OneSubject> list = subjectService.getAllSubject();
        if (CollectionUtils.isEmpty(list)) {
            return ReturnResult.failed("数据查询失败");
        }
        return ReturnResult.success("查询成功",list);
    }
}

