package com.lt.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 小狐
 * @since 2020-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("recommend_blog")
@ApiModel(value="RecommendBlog对象", description="")
public class RecommendBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "推荐标识id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "推荐博主的花名")
    private String name;

    @ApiModelProperty(value = "推荐博客的标题")
    private String title;

    @ApiModelProperty(value = "推荐博主的友链")
    private String linked;

    @ApiModelProperty(value = "推荐文章的友链")
    private String url;

    @ApiModelProperty(value = "推荐文章的描述")
    private String content;

    @ApiModelProperty(value = "分组id")
    private String groupId;

    @ApiModelProperty(value = "审核状态，0待审核，1审核通过")
    private Integer status;

    @ApiModelProperty(value = "分类的扩展信息")
    private String extend;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
