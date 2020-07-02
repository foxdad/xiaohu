package com.lt.blog.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: GroupDto
 * Description:
 * date: 2020/6/29 14:23
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class GroupDto implements Serializable {

    @ApiModelProperty(value = "分类名")
    private String groupName;

    @ApiModelProperty(value = "分类统计的文章数")
    private Integer count;
}
