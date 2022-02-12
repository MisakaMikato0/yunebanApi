package com.hua.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户登录实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AdminLogin对象",description = "")
public class AdminLoginParam {

    @ApiModelProperty(required = true,value = "用户名")
    private String username;
    @ApiModelProperty(required = true,value = "密码")
    private String password;

    @ApiModelProperty(required = true,value = "验证码")
    private String code;
}
