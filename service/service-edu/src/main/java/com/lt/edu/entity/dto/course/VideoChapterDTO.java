package com.lt.edu.entity.dto.course;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: VideoChapterDTO
 * Description:
 * date: 2020/6/23 14:42
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class VideoChapterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程名称")
    private String title;

    @ApiModelProperty(value = "视频id")
    private String videoSourceId;

    @ApiModelProperty(value = "视频名称")
    private String videoOriginalName;

    @ApiModelProperty(value = "显示排序")
    private Integer sort;

    @ApiModelProperty(value = "课程价格")
    private Integer free;
}
