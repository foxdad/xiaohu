package com.lt.edu.service;

import com.lt.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.edu.entity.vo.chapter.VideoVo;
import com.lt.edu.entity.vo.course.ChapterVo;
import com.lt.utils.ReturnResult;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
public interface ChapterService extends IService<Chapter> {

    ReturnResult getByIdChapter(String id);

    ReturnResult saveChapterVideo(VideoVo videoVo);

    ReturnResult removeChapter(String courseId, String title);

    ReturnResult updateChapter(VideoVo videoVo);
}
