package com.lt.ucenter.entity.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ClassName: LoginVo
 * Description:
 * date: 2020/6/11 15:28
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
@Api("登录信息")
public class LoginVo implements Serializable {

    @ApiModelProperty(value = "手机号")
    @NotNull(message = "登录的账号不能为空")
    private String mobile;

    @ApiModelProperty(value = "密码")
    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "微信operid")
    private String operid;

}
