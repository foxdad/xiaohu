package com.lt.ucenter.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ClassName: RegisterVo
 * Description:
 * date: 2020/6/10 16:20
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class RegisterVo implements Serializable {
    @ApiModelProperty(value = "手机号")
    @NotNull(message = "bad request")
    private String mobile;

    @ApiModelProperty(value = "密码")
    @NotNull(message = "bad request")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "验证码")
    @NotNull(message = "bad request")
    private String code;
}
