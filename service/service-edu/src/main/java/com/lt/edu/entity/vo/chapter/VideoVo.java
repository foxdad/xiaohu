package com.lt.edu.entity.vo.chapter;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ClassName: VideoVo
 * Description:
 * date: 2020/6/21 18:00
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class VideoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程id")
    private String courseId;

    @ApiModelProperty(value = "章节id")
    private String chapterId;

    @ApiModelProperty(value = "课程名称")
    @NotNull(message = "课程名称不能为空")
    private String title;

    @ApiModelProperty(value = "视频id")
    @NotNull(message = "上传id不能为空")
    private String videoSourceId;

    @ApiModelProperty(value = "视频名称")
    private String videoOriginalName;

    @ApiModelProperty(value = "显示排序")
    private Integer sort;

    @ApiModelProperty(value = "课程大小")
    private Long size;

    @ApiModelProperty(value = "课程价格")
    private Boolean Isfree;


}
