package com.lt.order.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ClassName: OrderVo
 * Description:
 * date: 2020/6/16 17:01
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class OrderVo implements Serializable {

    @ApiModelProperty(value = "课程id")
    @NotNull(message = "购买课程不能为空")
    private String courseId;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员昵称")
    private String nickname;

    @ApiModelProperty(value = "会员手机")
    private String mobile;

    @ApiModelProperty(value = "订单金额（分）")
    private BigDecimal totalFee;

}
