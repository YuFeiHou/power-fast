package com.power.fast.modules.sys.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录表单
 *
 * @author fei
 */
@Data
@ApiModel(value="登录表单",description="登录表单SysLoginForm")
public class SysLoginForm {
    @ApiModelProperty(value="用户名",dataType="String",example="admin")
    private String username;
    @ApiModelProperty(value="密码",dataType="String",example="admin")
    private String password;
    @ApiModelProperty(value="验证码",dataType="String",example="验证码")
    private String captcha;
    @ApiModelProperty(value="uuid",dataType="String",example="验证码id")
    private String uuid;
}
