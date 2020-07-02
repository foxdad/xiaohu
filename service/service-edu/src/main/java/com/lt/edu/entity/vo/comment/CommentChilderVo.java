package com.lt.edu.entity.vo.comment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName: CommentChilderVo
 * Description:
 * date: 2020/6/16 14:27
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class CommentChilderVo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程id")
    @NotNull(message = "课程id好像没有了")
    private String courseId;

    @ApiModelProperty(value = "评论父级id")
    @NotNull(message = "评论的地方不对呢")
    private String parentId;

    @ApiModelProperty(value = "回复用户")
    private String callNickname;

    @ApiModelProperty(value = "回复人图片")
    private String avater;

    @ApiModelProperty(value = "回复id")
    private String callId;

    @ApiModelProperty(value = "内容")
    @NotNull(message = "好像还没有评论呀")
    private String connet;

}
