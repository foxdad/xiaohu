package com.lt.blog.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: GroupVo
 * Description:
 * date: 2020/6/28 16:14
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class GroupVo implements Serializable {

    @ApiModelProperty(value = "分类标题")
    private String groupName;
}
