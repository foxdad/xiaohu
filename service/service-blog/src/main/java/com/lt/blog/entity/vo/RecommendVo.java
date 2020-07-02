package com.lt.blog.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: RecommendVo
 * Description:
 * date: 2020/6/28 11:41
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class RecommendVo  {

    @ApiModelProperty(value = "分类id")
    private String groupId;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "审核状态，0待审核，1审核通过")
    private Integer status;
}
