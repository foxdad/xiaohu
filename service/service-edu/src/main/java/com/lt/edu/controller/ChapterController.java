package com.lt.edu.controller;


import com.lt.config.execptionhandler.LtExecption;
import com.lt.edu.entity.vo.chapter.VideoVo;
import com.lt.edu.service.ChapterService;
import com.lt.utils.Constant;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
@Api(produces = "章节操作")
@Validated
@RestController
@RequestMapping("/edu/chapter")
//@CrossOrigin
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    /**
     * 前后台共用的方法
     * 根据课程id获取指定下的所有章节
     * @return
     */
    @GetMapping("/getByIdChapter/{id}")
    public ReturnResult getByIdChapter(@PathVariable("id")@NotNull(message = "bad request") String id ) {
        if (StringUtils.isEmpty(id)) {
            throw new LtExecption(Constant.CODE_FAILED,"数据异常");
        }
        ReturnResult chapterVoList = chapterService.getByIdChapter(id);
        return chapterVoList;
    }

    /**
     * TODO表设计的问题导致调用问题了
     * @param videoVo
     * @return
     */
    @PostMapping("/save/chapter")
    public ReturnResult saveChapter(@RequestBody VideoVo videoVo) {
           ReturnResult result= chapterService.saveChapterVideo(videoVo);
        return  result;
    }

    /**
     * 课程的章节的修改
     * @param videoVo
     * @return
     */
    @PostMapping("/update/chapter")
    public ReturnResult updateChapter(@RequestBody VideoVo videoVo) {

        ReturnResult result= chapterService.updateChapter(videoVo);
        return result;
    }

    /**
     * 课程的章节删除与课程的视频删除
     * @param courseId
     * @param title
     * @return
     */
    @DeleteMapping("/remove/chapter/{courseId}/{title}")
    public ReturnResult deleteChapter(@PathVariable("courseId")@NotNull(message = "bad request") String courseId,
                                      @PathVariable("title")@NotNull(message = "bad request") String title) {

        ReturnResult result= chapterService.removeChapter(courseId,title);
        return result;
    }

}

