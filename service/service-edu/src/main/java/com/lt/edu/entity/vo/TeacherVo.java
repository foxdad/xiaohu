package com.lt.edu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: TeacherVo
 * Description:
 * date: 2020/5/22 9:47
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherVo implements Serializable {
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;
}
