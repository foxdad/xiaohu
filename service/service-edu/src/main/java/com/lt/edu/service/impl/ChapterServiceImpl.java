package com.lt.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.edu.entity.Chapter;
import com.lt.utils.CommonEntity.Video;
import com.lt.edu.entity.dto.course.VideoChapterDTO;
import com.lt.edu.entity.vo.chapter.VideoVo;
import com.lt.edu.mapper.ChapterMapper;
import com.lt.edu.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.edu.service.VideoService;
import com.lt.utils.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private VideoService videoservice;

    @Resource
    private ChapterMapper chapterMapper;

    /**
     *
     * 此方法可以通过重新在maper文件里面冲洗sql，可以省去遍历
     * 此方法发生太多次查询
     * @param id
     * @return
     */
    @Override
    public ReturnResult getByIdChapter(String id) {

        List<VideoChapterDTO> challChapter = chapterMapper.getAllChapter(id);
        if (CollectionUtils.isEmpty(challChapter)) {
            return ReturnResult.failed("此课程暂时还没有具体章节信息");
        }
        return ReturnResult.success("查询成功",challChapter);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ReturnResult saveChapterVideo(VideoVo videoVo) {

        Chapter chapter = new Chapter();
//        BeanUtils.copyProperties(chapter,videoVo);
        chapter.setCourseId(videoVo.getCourseId());
        chapter.setSort(videoVo.getSort());
        chapter.setTitle(videoVo.getTitle());
        //保存章节
        int save = baseMapper.insert(chapter);
        if (save!=1) {
            return ReturnResult.failed("添加失败");
        }
        Video video = new Video();
//        BeanUtils.copyProperties(video,videoVo);
        video.setCourseId(videoVo.getCourseId());
        video.setTitle(videoVo.getTitle());
        video.setSize(videoVo.getSize());
        video.setVideoOriginalName(videoVo.getVideoOriginalName());
        video.setVideoSourceId(videoVo.getVideoSourceId());
        video.setSort(videoVo.getSort());
        video.setIsFree(videoVo.getIsfree());
        //把引用的章节id设置
        video.setChapterId(chapter.getId());
        boolean flag = videoservice.save(video);
        if (!flag) {
           ReturnResult.failed("添加失败");
        }
        return ReturnResult.success("添加成功",flag);
    }

    /**
     * TODO事务处理
     * @param courseId
     * @param title
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ReturnResult removeChapter(String courseId, String title) {
        QueryWrapper<Chapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        queryWrapper.eq("title",title);
        Chapter chapter = baseMapper.selectOne(queryWrapper);
        //删除课程
        int delete = baseMapper.delete(queryWrapper);
        //不判断了，失败回滚
        QueryWrapper<Video> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("chapter_id",chapter.getId());
        boolean remove = videoservice.remove(videoWrapper);

        return ReturnResult.success("删除成功",remove);
    }

    /**
     * TODO事务处理
     * @param videoVo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ReturnResult updateChapter(VideoVo videoVo) {
        QueryWrapper<Chapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",videoVo.getCourseId());
        queryWrapper.eq("title",videoVo.getTitle());
        Chapter chapter = baseMapper.selectOne(queryWrapper);

        chapter.setSort(videoVo.getSort());

        //修改课程
        int updateById = baseMapper.updateById(chapter);
        //不判断了，失败回滚
        QueryWrapper<Video> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("chapter_id",chapter.getId());
        Video video = videoservice.getOne(videoWrapper);
        video.setVideoOriginalName(videoVo.getVideoOriginalName());
        video.setVideoSourceId(videoVo.getVideoSourceId());

        boolean result = videoservice.updateById(video);


        return ReturnResult.success("删除成功",result);

    }
}
