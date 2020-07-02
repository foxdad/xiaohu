package com.lt.edu.entity.vo.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ClassName: CourseQueryVo
 * Description:
 * date: 2020/6/13 13:51
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
@ApiModel(value = "课程查询对象", description = "课程查询对象封装")
public class CourseQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程名称")
    @NotNull(message = "课程名称不能为空")
    private String title;

    @ApiModelProperty(value = "讲师id")
    @NotNull(message = "讲师不能为空")
    private String teacherId;

    @ApiModelProperty(value = "一级类别id")
    private String subjectParentId;

    @ApiModelProperty(value = "二级类别id")
    private String subjectId;

    @ApiModelProperty(value = "销量排序")
    private String buyCountSort;

    @ApiModelProperty(value = "最新时间排序")
    private String gmtCreateSort;

    @ApiModelProperty(value = "价格排序")
    private String priceSort;
}
