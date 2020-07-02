package com.lt.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.utils.CommonEntity.Video;
import com.lt.edu.service.VideoService;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
@Api(description = "视频的显示Controller")
@Validated
@RestController
@RequestMapping("/edu/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @ApiOperation("根据视频id查询课程是否免费")
    @GetMapping("/getByChapterId/{vedioId}")
    public ReturnResult getByChapterId (@PathVariable("vedioId")@NotNull(message = "bad request") String vedioId) {
        QueryWrapper<Video> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.eq("video_source_id",vedioId);

        Video video = videoService.getOne(videoQueryWrapper);
        if (video==null) {
            return ReturnResult.failed("错误跳转");
        }

        return ReturnResult.success("查询成功",video);

    }

}

