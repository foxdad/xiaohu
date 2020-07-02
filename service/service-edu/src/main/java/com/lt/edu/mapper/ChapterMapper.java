package com.lt.edu.mapper;

import com.lt.edu.entity.Chapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lt.edu.entity.dto.course.VideoChapterDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-27
 */
@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {
        List<VideoChapterDTO> getAllChapter(@Param("id") String id);
}
