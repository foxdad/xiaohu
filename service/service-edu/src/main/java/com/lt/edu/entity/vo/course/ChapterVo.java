package com.lt.edu.entity.vo.course;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * ClassName: VideoVo
 * Description:
 * date: 2020/6/1 22:59
 *
 * @author 刘腾
 * @since JDK 1.8
 */

@ApiModel(value = "章节信息")
@Data
public class ChapterVo {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private List<VideoVo> children;
}

