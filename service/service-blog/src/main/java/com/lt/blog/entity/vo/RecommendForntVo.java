package com.lt.blog.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: RecommendForntVo
 * Description:
 * date: 2020/6/28 15:09
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class RecommendForntVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "推荐标识id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "推荐博主的花名")
    @NotNull(message = "博主花名不能为空")
    private String name;

    @ApiModelProperty(value = "推荐博客的标题")
    @NotNull(message = "博客标题不能为空")
    private String title;

    @NotNull(message = "友链不能为空呀！")
    @ApiModelProperty(value = "推荐博主的友链")
    private String linked;

    @ApiModelProperty(value = "推荐文章的友链")
    @NotNull(message = "推荐的文章友链不能为空呢")
    private String url;

    @ApiModelProperty(value = "推荐文章的描述")
    private String content;

}
