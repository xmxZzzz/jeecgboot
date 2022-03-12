package com.example.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package: com.example.pojo.bo
 * @ClassName: UserBO
 * @Author: guoyy
 * @Description: 从前端传入的用户注册的参数对象，包含用户名、密码、确认密码
 * @Date: 2022/3/12 下午9:09
 * @Version: 1.0
 */
//修改请求参数的显示
@ApiModel(value = "用户对象BO", description = "从客户端由用户传入的数据封装在此entity中")
public class UserBO {

    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "imooc")
    private String username;
    @ApiModelProperty(value = "密码", name = "password", required = true, example = "123123")
    private String password;
    @ApiModelProperty(value = "确认密码", name = "confirmPassword", required = true, example = "123123")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
