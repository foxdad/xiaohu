package com.lt.edu.entity.vo.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ClassName: CommentVo
 * Description:
 * date: 2020/6/15 16:50
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class CommentVo implements Serializable {
    @ApiModelProperty(value = "课程id")
    @NotNull(message = "没有找到课程")
    private String courseId;

    @ApiModelProperty(value = "讲师id")
    @NotNull(message = "没有找到讲师")
    private String teacherId;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员昵称")
    private String nickname;

    @ApiModelProperty(value = "会员头像")
    private String avatar;

    @ApiModelProperty(value = "评论内容")
    @NotNull(message = "好像还没有评论呢")
    private String content;
}
