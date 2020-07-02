package com.lt.vedio.controller;


import com.lt.utils.ReturnResult;
import com.lt.vedio.service.EduVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-20
 */
@Api(description = "视频上传")
@RestController
@RequestMapping("/vedio/eduvideo")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    /**
     * 上传视频
     * @param file
     * @return
     */
    @ApiOperation("视频上传")
    @PostMapping("/upvedio")
    public ReturnResult upload(@RequestParam("file") MultipartFile file){

        String videoId = eduVideoService.uploadVideo(file);
        return ReturnResult.success("视频上传成功",videoId);
    }

    /**
     * 删除视频操作
     * @param vedioId
     * @return
     */
    @DeleteMapping("/deleteVedio/{vedioId}")
    public ReturnResult deleteVedio (@PathVariable("vedioId") String vedioId) {
        //删除视频
        eduVideoService.deleteVedio(vedioId);
        return ReturnResult.success("视频删除成功",null);
    }

    /**
     * TODO 功能还不完善(id加密)
     * 获取播放视频的凭证
     * @param videoId
     * @return
     * get-play-auth/{courseId}/{videoId}
     */
    @GetMapping("get-play-auth/{videoId}")
    public ReturnResult getVideoPlayAuth( @PathVariable("videoId") String videoId, HttpServletRequest request) {

        ReturnResult result = eduVideoService.getVideoPlayAuth(videoId,request);

        return result;
    }
}

