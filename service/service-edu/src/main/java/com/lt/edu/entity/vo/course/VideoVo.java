package com.lt.edu.entity.vo.course;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * ClassName: VideoVo
 * Description:
 * date: 2020/6/1 22:59
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@ApiModel("课时信息")
@Data
public class VideoVo {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private Boolean free;
}
