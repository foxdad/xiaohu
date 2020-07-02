package com.lt.edu.entity;

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
 * @since 2020-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_comment_childer")
@ApiModel(value="CommentChilder对象", description="")
public class CommentChilder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论子级id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "课程id")
    private String courseId;

    @ApiModelProperty(value = "评论父级id")
    private String parentId;

    @ApiModelProperty(value = "被回复id")
    private String byReplyId;

    @ApiModelProperty(value = "被回复用户")
    private String byReplyNickname;

    @ApiModelProperty(value = "被回复用户图片")
    private String byReplyIdAvater;

    @ApiModelProperty(value = "回复用户")
    private String callNickname;

    @ApiModelProperty(value = "回复人图片")
    private String avater;

    @ApiModelProperty(value = "回复id")
    private String callId;

    @ApiModelProperty(value = "内容")
    private String connet;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
